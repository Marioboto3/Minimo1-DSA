package edu.upc.dsa.models;

public class Play {

    private String titulo;
    private String artista;
    private String album;
    private double duracion;
    private String id;

    public Play(String titulo, String artista, String album, double duracion, String id) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.duracion = duracion;
        this.id=id;
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

    public String getId() {
        return id;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
}
