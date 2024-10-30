package pe.edu.upc.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Estilo")
public class Estilo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idEstilo;
    @Column(name = "NombreEstilo",length =100 ,nullable = false)
    private String Nombre;
    @ManyToOne
    @JoinColumn(name="idRostro")
    private Rostro ro;
    @Column(name = "CodigoColor",length =100 ,nullable = false)
    private String CodigoColor;
    @ManyToOne
    @JoinColumn(name="idItem")
    private Item it;

    public Estilo() {
    }

    public Estilo(int idEstilo, String nombre, Rostro ro, String codigoColor, Item it) {
        this.idEstilo = idEstilo;
        Nombre = nombre;
        this.ro = ro;
        CodigoColor = codigoColor;
        this.it = it;
    }

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

    public String getCodigoColor() {
        return CodigoColor;
    }

    public void setCodigoColor(String codigoColor) {
        CodigoColor = codigoColor;
    }

    public Item getIt() {
        return it;
    }

    public void setIt(Item it) {
        this.it = it;
    }
}
