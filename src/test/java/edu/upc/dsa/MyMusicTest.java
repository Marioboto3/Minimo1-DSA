package edu.upc.dsa;

import edu.upc.dsa.models.Artista;
import edu.upc.dsa.models.Play;
import edu.upc.dsa.models.Playlist;
import edu.upc.dsa.models.Usuario;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MyMusicTest {

    private MyMusic mm;

    @Before
    public void setUp() throws Exception {
        this.mm = MyMusicImpl.getInstance();

        Usuario u1 = this.mm.addUsuario("Mario","Sanchez","mariosanchez");
        Usuario u2 = this.mm.addUsuario("Carlo","Gattuso","carlogattuso");

        Assert.assertEquals("Mario",u1.getNombre());
        Assert.assertEquals("Gattuso",u2.getApellido());
        Assert.assertEquals("mariosanchez",u1.getId());

        Artista a1 = this.mm.addArtista("a1","Natos");
        Artista a2 = this.mm.addArtista("a2","Camaron");

        Assert.assertEquals("a1",a1.getId());
        Assert.assertEquals("Camaron",a2.getNombre());




    }

    @After
    public void tearDown(){
        this.mm.clear();
    }

    @Test
    public void addPlaylistTest(){
        Playlist playlist = this.mm.addPlaylist("playlist","Sombra","mariosanchez");
        Assert.assertEquals("playlist",playlist.getId());
    }

    @Test
    public void addTituloPlaylistTest(){
        Playlist p1 = this.mm.addPlaylist("playlist1","Oscuro","carlogattuso");
        Playlist playlist = this.mm.addTituloPlaylist("Claro", p1 );
        Assert.assertEquals("Claro",playlist.getTitulo());
    }

    @Test
    public void llistaPlaysTest(){

        Playlist playlist1 = this.mm.addPlaylist("playlist1","Pez","mariosanchez");
        Play play = this.mm.addPlay("Vida","a1","Perecer",3,"play1");
        this.mm.addPlaytoPlaylist(play,"mariosanchez","playlist1");
        List<Play> lista = this.mm.llistatPlaylist(playlist1);
        Assert.assertEquals(1,lista.size());
    }

}
