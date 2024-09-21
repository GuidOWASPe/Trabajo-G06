package pe.edu.upc.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Item")
public class Item {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idItem;
    @ManyToOne
    @JoinColumn(name="idTipo")
    private Tipo ti;
    @Column(name="nombreItem", length = 100, nullable = false)
    private String nombreItem;
    @Column(name="descripcionItem", length = 100, nullable = false)
    private String descripcionItem;
    @Column(name="calificacionItem", nullable = false)
    private int calificacionItem;
    @Column(name="nrUsos", nullable = false)
    private int nrUsos;
    @Column(name="imagen", length = 500, nullable = false)
    private String imagen;

    public Item() {
    }

    public Item(int idItem, Tipo ti, String nombreItem, String descripcionItem, int calificacionItem, int nrUsos, String imagen) {
        this.idItem = idItem;
        this.ti = ti;
        this.nombreItem = nombreItem;
        this.descripcionItem = descripcionItem;
        this.calificacionItem = calificacionItem;
        this.nrUsos = nrUsos;
        this.imagen = imagen;
    }

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
