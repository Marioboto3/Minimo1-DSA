package edu.upc.dsa;

import edu.upc.dsa.models.Artista;
import edu.upc.dsa.models.Play;
import edu.upc.dsa.models.Playlist;
import edu.upc.dsa.models.Usuario;

import java.util.List;

public interface MyMusic {

    public Play addPlay (String titulo, String artista, String album, double duracion, String id);
    public Usuario addUsuario (String nombre, String apellido, String id);
    public void addPlaytoPlaylist (Play p, String idUsuario, String idPlaylist);
    public Playlist addPlaylist (String id, String titulo, String idUsuario);
    public Artista addArtista (String id, String nombre);
    public List<Artista> artistasMyMusic ();
    public Playlist addTituloPlaylist (String titulo, Playlist p);
    public List<Play> llistatPlaylist (Playlist playlist);

    public Playlist findByIdPlaylist(String idPlaylist, String idUsuario);
    public Play findbyIdPlay(String idPlay);
    public Artista findbyIdArtista (String idArtista);
    public Usuario findByIdUsuario (String idUsuario);

    public int sizeUsuarios();
    public int sizeArtistas();

    public void clear();
}
