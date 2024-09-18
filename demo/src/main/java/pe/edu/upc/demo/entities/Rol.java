package pe.edu.upc.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Rol")
public class Rol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;
    @Column(name = "nombre",nullable = false,length = 100)
    private String Nombre;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private Usuario usEr;

    public Rol() {
    }

    public Rol(int idRol, String nombre, Usuario usEr) {
        this.idRol = idRol;
        Nombre = nombre;
        this.usEr = usEr;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Usuario getUsEr() {
        return usEr;
    }

    public void setUsEr(Usuario usEr) {
        this.usEr = usEr;
    }
}
