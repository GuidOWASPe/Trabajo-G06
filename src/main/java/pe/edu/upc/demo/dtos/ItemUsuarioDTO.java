package pe.edu.upc.demo.dtos;

import jakarta.persistence.*;
import pe.edu.upc.demo.entities.Usuario;
import pe.edu.upc.demo.entities.Item;

import java.time.LocalDate;
import java.util.Date;

public class ItemUsuarioDTO {
    private int idItemFavorito;
    private Date fechaItemFavorito;
    private int Calificacion;
    private Usuario us;
    private Item it;

    public int getIdItemFavorito() {
        return idItemFavorito;
    }

    public void setIdItemFavorito(int idItemFavorito) {
        this.idItemFavorito = idItemFavorito;
    }

    public Date getFechaItemFavorito() {
        return fechaItemFavorito;
    }

    public void setFechaItemFavorito(Date fechaItemFavorito) {
        this.fechaItemFavorito = fechaItemFavorito;
    }

    public int getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(int calificacion) {
        Calificacion = calificacion;
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
