package pe.edu.upc.demo.dtos;

import pe.edu.upc.demo.entities.Estilo;
import pe.edu.upc.demo.entities.Usuario;

import java.time.LocalDate;

public class ComentarioDTO {
    private  int idcomentario;
    private String contenido;
    private int likes;
    private LocalDate fecha_publicada;
    private Usuario us;
    private Estilo et;

    public int getIdcomentario() {
        return idcomentario;
    }

    public void setIdcomentario(int idcomentario) {
        this.idcomentario = idcomentario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public LocalDate getFecha_publicada() {
        return fecha_publicada;
    }

    public void setFecha_publicada(LocalDate fecha_publicada) {
        this.fecha_publicada = fecha_publicada;
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }

    public Estilo getEt() {
        return et;
    }

    public void setEt(Estilo et) {
        this.et = et;
    }
}