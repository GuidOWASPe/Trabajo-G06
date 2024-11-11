package pe.edu.upc.demo.dtos;

import pe.edu.upc.demo.entities.Usuario;
import pe.edu.upc.demo.entities.Forma;


public class RostroDTO {
    private int idRostro;
    private String Nombre;
    private String imagenRostro;
    private Usuario usu;
    private Forma fo;

    public int getIdRostro() {
        return idRostro;
    }

    public void setIdRostro(int idRostro) {
        this.idRostro = idRostro;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getImagenRostro() {
        return imagenRostro;
    }

    public void setImagenRostro(String imagenRostro) {
        this.imagenRostro = imagenRostro;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public Forma getFo() {
        return fo;
    }

    public void setFo(Forma fo) {
        this.fo = fo;
    }
}
