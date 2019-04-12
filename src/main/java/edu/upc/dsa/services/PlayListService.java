package edu.upc.dsa.services;

import edu.upc.dsa.MyMusic;
import edu.upc.dsa.MyMusicImpl;
import edu.upc.dsa.TracksManager;
import edu.upc.dsa.TracksManagerImpl;
import edu.upc.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api(value = "/playList", description = "Endpoint to playList Service")
@Path("/playList")
public class PlayListService {

    private MyMusic mm;

    public PlayListService(){
        this.mm = MyMusicImpl.getInstance();

        if (mm.sizeArtistas()==0&&mm.sizeUsuarios()==0)
        {
            this.mm.addArtista("artista1","Natos");

            this.mm.addUsuario("Mario","Sanchez","mariosanchez");

            this.mm.addPlaylist("playlist1","Aprobado","mariosanchez");

            this.mm.addPlay("Play1","artista1","verte",2,"play1");

            Play p = this.mm.findbyIdPlay("play1");

            this.mm.addPlaytoPlaylist(p,"mariosanchez","playlist1");
        }
    }
    @POST
    @ApiOperation(value = "crea una Playlist", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= PlaylistTO.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newPlaylist(PlaylistTO playlist) {

        if(playlist==null) return Response.status(500).build();

        Playlist p = mm.addPlaylist(playlist.getId(),playlist.getTitulo(),playlist.getIdUsuario());

        GenericEntity<PlaylistTO> entity = new GenericEntity<PlaylistTO>(playlist) {};

        return Response.status(201).entity(entity).build();

    }

    @PUT
    @ApiOperation(value = "update a Titulo de Playlist", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Playlist not found")
    })
    @Path("/")
    public Response updatePlaylist(PlaylistTO playlist) {

        Playlist playlist1 = this.mm.findByIdPlaylist(playlist.getId(),playlist.getIdUsuario());
        if(playlist1==null) return Response.status(404).build();

        Playlist p = this.mm.addTituloPlaylist(playlist.getTitulo(),playlist1);
        PlaylistTO pTO = new PlaylistTO(p.getId(),p.getTitulo(),p.getIdUsuario());
        return Response.status(201).build();
    }
    @GET
    @ApiOperation(value = "get all Plays de Playlist", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Play.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "Playlist not found"),
            @ApiResponse(code = 405, message = "not Plays")
    })
    @Path("/{idPlaylist}/{idUsuario}/plays")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlaysPlaylist(@PathParam("idPlaylist") String idPlaylist,@PathParam("idUsuario") String idUsuario) {

        Playlist p = this.mm.findByIdPlaylist(idPlaylist,idUsuario);

        if(p==null)
        {
            return Response.status(404).build();
        }
        List<Play> plays = this.mm.llistatPlaylist(p);
        if(plays==null)
        {
            return Response.status(405).build();
        }

        GenericEntity<List<Play>> entity = new GenericEntity<List<Play>>(plays) {};
        return Response.status(201).entity(entity).build()  ;

    }

}
