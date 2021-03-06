package edu.upc.dsa;

import edu.upc.dsa.models.Artista;
import edu.upc.dsa.models.Play;
import edu.upc.dsa.models.Playlist;
import edu.upc.dsa.models.Usuario;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MyMusicImpl implements MyMusic {
    private static MyMusic instance;
    private HashMap<String, Usuario> usuarios;
    private LinkedList<Artista> artistas;
    private HashMap<String, Play> plays;

    final static Logger logger = Logger.getLogger(MyMusicImpl.class);

    private MyMusicImpl(){
        this.usuarios= new HashMap<>();
        this.artistas= new LinkedList<>();
        this.plays = new HashMap<>();
    }

    public static MyMusic getInstance() {
        if (instance==null) instance = new MyMusicImpl();
        return instance;
    }


    @Override
    public Play addPlay(String titulo, String idArtista, String album, double duracion, String id) {
        Play p = this.findbyIdPlay(id);
        if(p==null)
        {
            Artista a = this.findbyIdArtista(idArtista);
            if (a==null)
            {
                logger.info("artista no encontrado ");

                return null;
            }
            p = new Play(titulo, a.getNombre(), album, duracion, id);
            this.plays.put(id, p);
            logger.info("new Play " + p);
            return p;
        }
        //excepcion
        return null;
    }

    @Override
    public Usuario addUsuario(String nombre, String apellido, String id) {
        Usuario usuario = this.findByIdUsuario(id);
        if ( usuario == null){
            usuario = new Usuario(nombre, apellido, id);
            this.usuarios.put(id,usuario);
            logger.info("new usuario " + usuario);

            return usuario;
        }
        logger.info("usuario no encontrado ");

        return null;
    }

    @Override
    public void addPlaytoPlaylist(Play p, String idUsuario, String idPlaylist) {
        Usuario u = this.usuarios.get(idUsuario);
        Playlist playlist = u.getPlaylist(idPlaylist);
        if (u!=null && playlist!=null){
            playlist.addPlay(p);
            logger.info("new play " + p);

        }
        logger.info("playlist or usuario no encontrados " );
    }

    @Override
    public Playlist addPlaylist(String idPlaylist, String titulo, String idUsuario) {
        Playlist p = this.findByIdPlaylist(idPlaylist, idUsuario);
        if (p==null){
            p = new Playlist(idPlaylist, titulo, idUsuario);
            this.usuarios.get(idUsuario).addPlaylist(p);
            logger.info("new Playlist " + p);

            return p;
        }
        logger.info("Playlist no encontrado " );

        return null;
    }

    @Override
    public Artista addArtista(String id, String nombre) {
        Artista artista = this.findbyIdArtista(id);
        if(artista == null)
        {
            artista = new Artista(id, nombre);
            this.artistas.add(artista);
            logger.info("new artista " + artista);
            return artista;
        }
        logger.info("artista no encontrado");

        return null;
    }

    @Override
    public List<Artista> artistasMyMusic() {
        List<Artista> lista = this.artistas;
        logger.info("lista artistas " + lista);

        return lista;
    }

    @Override
    public Playlist addTituloPlaylist(String titulo, Playlist p) {
        Playlist playlist = this.findByIdPlaylist(p.getId(), p.getIdUsuario());
        if(playlist==null)
        {
            logger.info("playlist no encontrado");

            return null;

        }
        else{
            playlist.setTitulo(titulo);
            logger.info("new titulo " + titulo);

            return playlist;
        }
    }

    @Override
    public List<Play> llistatPlaylist(Playlist playlist) {
        Playlist p = this.findByIdPlaylist(playlist.getId(), playlist.getIdUsuario());
        if(p!=null) {
            List<Play> listaPlay = p.getListaPlays();
            logger.info("listaplays"+ listaPlay);

            return listaPlay;
        }
        logger.info("not created");

        return null;

    }

    @Override
    public Playlist findByIdPlaylist(String idPlaylist, String idUsuario) {
        Playlist p = this.usuarios.get(idUsuario).getPlaylist(idPlaylist);
        if (p==null) {
            logger.info("not found");

            return null;
        }
        return p;
    }

    @Override
    public Play findbyIdPlay(String idPlay) {
        Play p = this.plays.get(idPlay);
        if(p==null) {
            logger.info("not found");
            return null;
        }
        logger.info("encontrado"+p);
        return p;
    }

    @Override
    public Artista findbyIdArtista(String idArtista) {
        for (Artista a : this.artistas)
        {
            if(a.getId().equals(idArtista)){
                logger.info("encontrado"+a);


                return a;
            }
        }
        logger.info("not found");
        return null;
    }

    @Override
    public Usuario findByIdUsuario(String idUsuario) {
        Usuario usuario = this.usuarios.get(idUsuario);
        if(usuario==null){
            logger.info("not found");
            return null;
        }
        logger.info("encontrado"+usuario);

        return usuario;
    }

    @Override
    public int sizeUsuarios() {
        return this.usuarios.size();
    }

    @Override
    public int sizeArtistas() {
        return this.artistas.size();
    }

    @Override
    public void clear() {
        this.usuarios.clear();
        this.artistas.clear();
        this.plays.clear();
    }
}
