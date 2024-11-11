package pe.edu.upc.demo.entities;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="EstiloUsuario")
public class EstiloUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstiloUsuario;
    @Column(name = "fechaEstiloFav", nullable = true)
    private LocalDate fechaEstiloFav;
    @Column(name = "calificacionEstilo", nullable = true)
    private int calificacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idEstilo")
    private Estilo estilo;

    public EstiloUsuario() {

    }

    public EstiloUsuario(int idEstiloUsuario, LocalDate fechaEstiloFav, int calificacion, Usuario usuario, Estilo estilo) {
        this.idEstiloUsuario = idEstiloUsuario;
        this.fechaEstiloFav = fechaEstiloFav;
        this.calificacion = calificacion;
        this.usuario = usuario;
        this.estilo = estilo;
    }

    public int getIdEstiloUsuario() {
        return idEstiloUsuario;
    }

    public void setIdEstiloUsuario(int idEstiloUsuario) {
        this.idEstiloUsuario = idEstiloUsuario;
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


