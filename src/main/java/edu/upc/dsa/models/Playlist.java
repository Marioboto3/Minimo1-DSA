package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.LinkedList;

public class Playlist {
    private String id;
    private String titulo;
    private ArrayList<Play> listaPlays;
    private LinkedList<String> titulosPlays;

    public Playlist(String id, String titulo) {
        this.id = id;
        this.titulo=titulo;
        this.listaPlays = new ArrayList<>();
        this.titulosPlays = new LinkedList<>();
    }

    public Playlist() {
    }

    public String getId() {
        return id;
    }

    public ArrayList<Play> getListaPlays() {
        return listaPlays;
    }

    public LinkedList<String> getTitulosPlays() {
        return titulosPlays;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setListaPlays(ArrayList<Play> listaPlays) {
        this.listaPlays = listaPlays;
    }

    public void setTitulosPlays(LinkedList<String> titulosPlays) {
        this.titulosPlays = titulosPlays;
    }
}
