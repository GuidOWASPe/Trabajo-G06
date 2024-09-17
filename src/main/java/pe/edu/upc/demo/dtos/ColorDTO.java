package pe.edu.upc.demo.dtos;

import java.time.LocalDate;

public class ColorDTO {
    private int idColor;
    private String nombreColor;

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
