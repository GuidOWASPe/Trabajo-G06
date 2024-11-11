package pe.edu.upc.demo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Estilo")
public class Estilo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idEstilo;
    @Column(name = "NombreEstilo",length =100 ,nullable = false)
    private String NombreEstilo;
    @ManyToOne
    @JoinColumn(name="idRostro")
    private Rostro ro;
    @Column(name = "CodigoColor",length =100 ,nullable = false)
    private String CodigoColor;
    @ManyToOne
    @JoinColumn(name="idItem")
    private Item it;
    @Column(name = "FechaCreado",nullable = false)
    private LocalDate FechaCreado;
    @Column(name = "ImagenEstilo", nullable = false, length = 500)
    private String ImagenEstilo;

    public Estilo() {
    }

    public Estilo(int idEstilo, String nombreEstilo, Rostro ro, String codigoColor, Item it, LocalDate fechaCreado, String imagenEstilo) {
        this.idEstilo = idEstilo;
        NombreEstilo = nombreEstilo;
        this.ro = ro;
        CodigoColor = codigoColor;
        this.it = it;
        FechaCreado = fechaCreado;
        ImagenEstilo = imagenEstilo;
    }

    public int getIdEstilo() {
        return idEstilo;
    }

    public void setIdEstilo(int idEstilo) {
        this.idEstilo = idEstilo;
    }

    public String getNombreEstilo() {
        return NombreEstilo;
    }

    public void setNombreEstilo(String nombreEstilo) {
        NombreEstilo = nombreEstilo;
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

    public LocalDate getFechaCreado() {
        return FechaCreado;
    }

    public void setFechaCreado(LocalDate fechaCreado) {
        FechaCreado = fechaCreado;
    }

    public String getImagenEstilo() {
        return ImagenEstilo;
    }

    public void setImagenEstilo(String imagenEstilo) {
        ImagenEstilo = imagenEstilo;
    }
}
