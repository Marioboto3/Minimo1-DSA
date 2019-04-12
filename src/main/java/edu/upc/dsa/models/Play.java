package edu.upc.dsa.models;

public class Play {

    private String titulo;
    private String artista;
    private String album;
    private double duracion;
    private String idPlaylist;

    public Play(String titulo, String artista, String album, double duracion, String idPlaylist) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.duracion = duracion;
        this.idPlaylist=idPlaylist;
    }

    public Play() {
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public String getAlbum() {
        return album;
    }

    public String getIdPlaylist() {
        return idPlaylist;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setIdPlaylist(String idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
}
