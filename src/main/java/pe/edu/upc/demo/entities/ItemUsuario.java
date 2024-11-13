package pe.edu.upc.demo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "ItemUsuario")

public class ItemUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idItemUsuario;
    @Column(name = "fechaitemFavorito", nullable = true)
    private Date fechaItemFavorito;
    @Column(name = "calificacion", nullable = true)
    private int calificacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario us;

    @ManyToOne
    @JoinColumn(name = "idItem")
    private Item it;

    public ItemUsuario() {
    }

    public ItemUsuario(int idItemUsuario, Date fechaItemFavorito, int calificacion, Usuario us, Item it) {
        this.idItemUsuario = idItemUsuario;
        this.fechaItemFavorito = fechaItemFavorito;
        this.calificacion = calificacion;
        this.us = us;
        this.it = it;
    }

    public int getIdItemUsuario() {
        return idItemUsuario;
    }

    public void setIdItemUsuario(int idItemUsuario) {
        this.idItemUsuario = idItemUsuario;
    }

    public Date getFechaItemFavorito() {
        return fechaItemFavorito;
    }

    public void setFechaItemFavorito(Date fechaItemFavorito) {
        this.fechaItemFavorito = fechaItemFavorito;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }

    public Item getIt() {
        return it;
    }

    public void setIt(Item it) {
        this.it = it;
    }
}
