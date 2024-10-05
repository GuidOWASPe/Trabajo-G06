package pe.edu.upc.demo.dtos;

import pe.edu.upc.demo.entities.Color;
import pe.edu.upc.demo.entities.Rostro;

public class EstiloDTO {

    private int idEstilo;

    private String Nombre;

    private Rostro ro;

    private Color co;

    public int getIdEstilo() {
        return idEstilo;
    }

    public void setIdEstilo(int idEstilo) {
        this.idEstilo = idEstilo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Rostro getRo() {
        return ro;
    }

    public void setRo(Rostro ro) {
        this.ro = ro;
    }

    public Color getCo() {
        return co;
    }

    public void setCo(Color co) {
        this.co = co;
    }
}
