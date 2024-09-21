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
    @ManyToOne
    @JoinColumn(name="idColor")
    private Color co;
    public Estilo() {
    }
    public Estilo(int idEstilo, String nombre, Rostro ro, Color co) {
        this.idEstilo = idEstilo;
        Nombre = nombre;
        this.ro = ro;
        this.co = co;
    }

    public int getIdEstilo() {
        return idEstilo;
    }

    public void setIdEstilo(int idEstilo) {
        this.idEstilo = idEstilo;
    }

    public Color getCo() {
        return co;
    }

    public void setCo(Color co) {
        this.co = co;
    }

    public Rostro getRo() {
        return ro;
    }

    public void setRo(Rostro ro) {
        this.ro = ro;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
