package pe.edu.upc.demo.dtos;

import pe.edu.upc.demo.entities.Usuario;
import pe.edu.upc.demo.entities.Item;

import java.time.LocalDate;
import java.util.Date;

public class ItemUsuarioDTO {
    private int idItemUsuario;
    private LocalDate fechaItemFavorito;
    private int Calificacion;
    private Usuario us;
    private Item it;

    public int getIdItemUsuario() {
        return idItemUsuario;
    }

    public void setIdItemUsuario(int idItemUsuario) {
        this.idItemUsuario = idItemUsuario;
    }

    public LocalDate getFechaItemFavorito() {
        return fechaItemFavorito;
    }

    public void setFechaItemFavorito(LocalDate fechaItemFavorito) {
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
