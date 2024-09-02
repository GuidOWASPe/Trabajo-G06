package pe.edu.upc.demo.dtos;

import java.time.LocalDate;

public class RolDTO {
    private int idRol;
    private String Nombre;

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
}
