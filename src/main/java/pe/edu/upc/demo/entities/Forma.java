package pe.edu.upc.demo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Forma")
public class Forma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idForma;
    @Column(name = "nombreForma",nullable = false,length = 100)
    private String nombreForma;
    @Column(name = "descripcionForma",nullable = false,length = 100)
    private String descripcionForma;

    public Forma(){
    }

    public Forma(int idForma, String nombreForma, String descripcionForma) {
        this.idForma = idForma;
        this.nombreForma = nombreForma;
        this.descripcionForma = descripcionForma;
    }

    public int getIdForma() {
        return idForma;
    }

    public void setIdForma(int idForma) {
        this.idForma = idForma;
    }

    public String getNombreForma() {
        return nombreForma;
    }

    public void setNombreForma(String nombreForma) {
        this.nombreForma = nombreForma;
    }

    public String getDescripcionForma() {
        return descripcionForma;
    }

    public void setDescripcionForma(String descripcionForma) {
        this.descripcionForma = descripcionForma;
    }
}
