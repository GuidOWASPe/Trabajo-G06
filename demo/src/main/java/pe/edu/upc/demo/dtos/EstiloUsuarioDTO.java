package pe.edu.upc.demo.dtos;

import pe.edu.upc.demo.entities.Estilo;
import pe.edu.upc.demo.entities.Usuario;

import java.time.LocalDate;

public class EstiloUsuarioDTO {
    private int idEstiloFav;
    private LocalDate fechaEstiloFav;
    private int calificacion;
    private Usuario usuario;
    private Estilo estilo;

    public int getIdEstiloFav() {
        return idEstiloFav;
    }

    public void setIdEstiloFav(int idEstiloFav) {
        this.idEstiloFav = idEstiloFav;
    }

    public LocalDate getFechaEstiloFav() {
        return fechaEstiloFav;
    }

    public void setFechaEstiloFav(LocalDate fechaEstiloFav) {
        this.fechaEstiloFav = fechaEstiloFav;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }
}