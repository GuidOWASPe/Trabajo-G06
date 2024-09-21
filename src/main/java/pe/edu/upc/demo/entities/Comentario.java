package pe.edu.upc.demo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComentario;
    @Column(name = "contenido", nullable = false, length = 500)
    private String contenido;
    @Column(name = "likes", nullable = false)
    private int likes;
    @Column(name = "fecha_publicada", nullable = false)
    private LocalDate fecha_publicada;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario us;

    @ManyToOne
    @JoinColumn(name = "idEstilo")
    private Estilo et;

    public Comentario() {

    }

    public Comentario(int idComentario, String contenido, LocalDate fecha_publicada, int likes, Usuario us, Estilo et) {
        this.idComentario = idComentario;
        this.contenido = contenido;
        this.likes = likes;
        this.fecha_publicada = fecha_publicada;
        this.us = us;
        this.et = et;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
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