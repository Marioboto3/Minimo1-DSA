package edu.upc.dsa.services;

import edu.upc.dsa.MyMusic;
import edu.upc.dsa.MyMusicImpl;
import edu.upc.dsa.models.Artista;
import edu.upc.dsa.models.Playlist;
import edu.upc.dsa.models.PlaylistTO;
import edu.upc.dsa.models.Track;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/artista", description = "Endpoint to playList Service")
@Path("/artista")
public class ArtistaService {

    private MyMusic mm;

    public ArtistaService() {
        this.mm = MyMusicImpl.getInstance();
        if (mm.sizeArtistas() == 0 && mm.sizeUsuarios() == 0) {
            this.mm.addArtista("artista1", "Natos");

        }
    }
    @POST
    @ApiOperation(value = "crea un Artista", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Artista.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newArtista(Artista artista) {

        if(artista==null) return Response.status(500).build();

        Artista a = mm.addArtista(artista.getId(),artista.getNombre());

        return Response.status(201).entity(a).build();

    }
    @GET
    @ApiOperation(value = "get all Artistas", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Artista.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getArtistas() {

        List<Artista> artistas = this.mm.artistasMyMusic();
        GenericEntity<List<Artista>> entity = new GenericEntity<List<Artista>>(artistas) {};
        return Response.status(201).entity(entity).build();

    }
}
