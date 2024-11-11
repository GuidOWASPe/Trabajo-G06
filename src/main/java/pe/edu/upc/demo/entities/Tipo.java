package pe.edu.upc.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Tipo")
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idTipo;
        @Column(name = "nombreTipo",nullable = false,length = 20)
        private String nombreTipo;

    public Tipo() {
    }

    public Tipo(int idTipo, String nombreTipo) {
        this.idTipo = idTipo;
        this.nombreTipo = nombreTipo;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
}


