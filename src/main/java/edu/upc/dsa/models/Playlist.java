package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.LinkedList;

public class Playlist {
    private String id;
    private String titulo;
    private ArrayList<Play> listaPlays;
    private LinkedList<String> titulosPlays;
    private String idUsuario;

    public Playlist(String id, String titulo, String idUsuario) {
        this.id = id;
        this.titulo=titulo;
        this.idUsuario=idUsuario;
        this.listaPlays = new ArrayList<>();
        this.titulosPlays = new LinkedList<>();
    }

    public Playlist() {
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

    public ArrayList<Play> getListaPlays() {
        return listaPlays;
    }

    public LinkedList<String> getTitulosPlays() {
        return titulosPlays;
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

    public void setListaPlays(ArrayList<Play> listaPlays) {
        this.listaPlays = listaPlays;
    }

    public void setTitulosPlays(LinkedList<String> titulosPlays) {
        this.titulosPlays = titulosPlays;
    }
    public Play addPlay(Play p){
        for (Play play : this.listaPlays){
            if (play.getId().equals(p.getId())){
                return null;
            }
        }
        this.listaPlays.add(p);
        return p;
    }
}
