package edu.upc.dsa;

import edu.upc.dsa.models.Artista;
import edu.upc.dsa.models.Play;
import edu.upc.dsa.models.Playlist;
import edu.upc.dsa.models.Usuario;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MyMusicImpl implements MyMusic {
    private static MyMusic instance;
    private HashMap<String, Usuario> usuarios;
    private LinkedList<Artista> artistas;

    final static Logger logger = Logger.getLogger(MyMusicImpl.class);

    private MyMusicImpl(){
        this.usuarios= new HashMap<>();
        this.artistas= new LinkedList<>();
    }

    public static MyMusic getInstance() {
        if (instance==null) instance = new MyMusicImpl();
        return instance;
    }


    @Override
    public Play addPlay(String titulo, String artista, String album, double duracion, String idPlaylist) {
        return null;
    }

    @Override
    public Playlist addPlaylist(String id, String titulo) {

        return null;
    }

    @Override
    public Artista addArtista(String id, String nombre) {
        return null;
    }

    @Override
    public List<Artista> artistasMyMusic() {
        return null;
    }

    @Override
    public void addTituloPlaylist(String titulo) {

    }

    @Override
    public Playlist findById(String id) {
        return null;
    }
}
