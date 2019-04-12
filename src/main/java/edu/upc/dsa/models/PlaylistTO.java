package edu.upc.dsa.models;

public class PlaylistTO {

    private String id;
    private String titulo;
    private String idUsuario;

    public PlaylistTO(String id, String titulo, String idUsuario) {
        this.id = id;
        this.titulo = titulo;
        this.idUsuario = idUsuario;
    }

    public PlaylistTO() {
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
