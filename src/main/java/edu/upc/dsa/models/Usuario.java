package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.LinkedList;

public class Usuario {
    private String nombre;
    private String apellido;
    private String id;
    private ArrayList<Playlist> listaPlays;

    public Usuario(String nombre, String apellido, String id, ArrayList<Playlist> listaPlays) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.listaPlays = listaPlays;
    }

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Playlist> getListaPlays() {
        return listaPlays;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setListaPlays(ArrayList<Playlist> listaPlays) {
        this.listaPlays = listaPlays;
    }

}
