package edu.upc.dsa.services;

import edu.upc.dsa.MyMusic;
import edu.upc.dsa.MyMusicImpl;
import edu.upc.dsa.TracksManager;
import edu.upc.dsa.TracksManagerImpl;
import edu.upc.dsa.models.Playlist;
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
        }
    }
    @POST
    @ApiOperation(value = "crea una Playlist", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Playlist.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newPlaylist(Playlist playlist) {

        if(playlist==null) return Response.status(500).build();

        Playlist p = mm.addPlaylist(playlist.getId(),playlist.getTitulo(),playlist.getIdUsuario());

        GenericEntity<Playlist> entity = new GenericEntity<Playlist>(p) {};

        return Response.status(201).entity(entity).build();

    }

}
