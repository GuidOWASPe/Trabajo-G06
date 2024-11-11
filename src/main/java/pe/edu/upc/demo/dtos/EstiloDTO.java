package pe.edu.upc.demo.dtos;
import pe.edu.upc.demo.entities.Item;
import pe.edu.upc.demo.entities.Rostro;

import java.time.LocalDate;

public class EstiloDTO {

    private int idEstilo;

    private String NombreEstilo;

    private Rostro ro;

    private String CodigoColor;

    private Item it;

    private LocalDate FechaCreado;

    private String ImagenEstilo;

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
