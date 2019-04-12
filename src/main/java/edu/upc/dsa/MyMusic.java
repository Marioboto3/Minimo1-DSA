package edu.upc.dsa;

import edu.upc.dsa.models.Artista;
import edu.upc.dsa.models.Play;
import edu.upc.dsa.models.Playlist;

import java.util.List;

public interface MyMusic {

    public Play addPlay (String titulo, String artista, String album, double duracion, String idPlaylist);
    public Playlist addPlaylist (String id, String titulo);
    public Artista addArtista (String id, String nombre);
    public List<Artista> artistasMyMusic ();
    public void addTituloPlaylist (String titulo);

    public Playlist findById(String id);

    
}
