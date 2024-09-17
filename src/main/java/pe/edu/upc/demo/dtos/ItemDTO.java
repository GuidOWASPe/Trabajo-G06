package pe.edu.upc.demo.dtos;
import pe.edu.upc.demo.entities.Tipo;

public class ItemDTO {
    private int idItem;
    private Tipo ti;
    private String nombreItem;
    private String descripcionItem;
    private int calificacionItem;
    private int nrUsos;
    private String imagen;

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public Tipo getTi() {
        return ti;
    }

    public void setTi(Tipo ti) {
        this.ti = ti;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public String getDescripcionItem() {
        return descripcionItem;
    }

    public void setDescripcionItem(String descripcionItem) {
        this.descripcionItem = descripcionItem;
    }

    public int getCalificacionItem() {
        return calificacionItem;
    }

    public void setCalificacionItem(int calificacionItem) {
        this.calificacionItem = calificacionItem;
    }

    public int getNrUsos() {
        return nrUsos;
    }

    public void setNrUsos(int nrUsos) {
        this.nrUsos = nrUsos;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
