package edu.upc.dsa.models;

public class Artista {

    private String id;
    private String nombre;

    public Artista(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Artista() {
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
