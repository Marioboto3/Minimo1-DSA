package edu.upc.dsa.models;

public class PlaylistTOtitulo {
    String titulo;
    String idPlaylist;
    String idUsuario;

    public PlaylistTOtitulo(String titulo, String idPlaylist, String idUsuario) {
        this.titulo = titulo;
        this.idPlaylist = idPlaylist;
        this.idUsuario=idUsuario;
    }

    public PlaylistTOtitulo() {
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getIdPlaylist() {
        return idPlaylist;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setIdPlaylist(String idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
