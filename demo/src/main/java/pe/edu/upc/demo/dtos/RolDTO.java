package pe.edu.upc.demo.dtos;

import pe.edu.upc.demo.entities.Usuario;

import java.time.LocalDate;

public class RolDTO {
    private int idRol;
    private String Nombre;
    private Usuario user;

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

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
