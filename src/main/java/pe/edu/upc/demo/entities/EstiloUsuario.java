package pe.edu.upc.demo.entities;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="EstiloUsuario")
public class EstiloUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstiloFav;
    @Column(name = "fechaEstiloFav", nullable = false)
    private LocalDate fechaEstiloFav;
    @Column(name = "calificacionEstilo", nullable = false)
    private int calificacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idEstilo")
    private Estilo estilo;

    public EstiloUsuario() {

    }

    public EstiloUsuario(int idEstiloFav, LocalDate fechaEstiloFav, int calificacion, Usuario usuario, Estilo estilo) {
        this.idEstiloFav = idEstiloFav;
        this.fechaEstiloFav = fechaEstiloFav;
        this.calificacion = calificacion;
        this.usuario = usuario;
        this.estilo = estilo;
    }

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


