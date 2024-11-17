package pe.edu.upc.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Rostro")

public class Rostro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRostro;
    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "ImagenRostro", nullable = false, length = 500)
    private String imagenRostro;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usu;

    @ManyToOne
    @JoinColumn(name = "idForma")
    private Forma fo;

    public Rostro() {
    }

    public Rostro(int idRostro, String nombre, String imagenRostro, Usuario usu, Forma fo) {
        this.idRostro = idRostro;
        this.nombre = nombre;
        this.imagenRostro = imagenRostro;
        this.usu = usu;
        this.fo = fo;
    }

    public int getIdRostro() {
        return idRostro;
    }

    public void setIdRostro(int idRostro) {
        this.idRostro = idRostro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
