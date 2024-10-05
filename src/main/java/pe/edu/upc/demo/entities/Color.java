package pe.edu.upc.demo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Color")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idColor;
    @Column(name = "nombreColor",nullable = false,length = 100)
    private String nombreColor;

    public Color(){
    }

    public Color(int idColor, String nombreColor){
        this.idColor = idColor;
        this.nombreColor = nombreColor;
    }

    public int getIdColor() {
        return idColor;
    }

    public void setIdColor(int idColor) {
        this.idColor = idColor;
    }

    public String getNombreColor() {
        return nombreColor;
    }

    public void setNombreColor(String nombreColor) {
        this.nombreColor = nombreColor;
    }
}
