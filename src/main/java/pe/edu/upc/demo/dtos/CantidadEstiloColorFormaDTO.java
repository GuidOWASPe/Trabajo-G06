package pe.edu.upc.demo.dtos;

public class CantidadEstiloColorFormaDTO {
    private String nombreForma;
    private String codigoColor;
    private int cantidadEstilo;

    public String getNombreForma() {
        return nombreForma;
    }

    public void setNombreForma(String nombreForma) {
        this.nombreForma = nombreForma;
    }

    public String getCodigoColor() {
        return codigoColor;
    }

    public void setCodigoColor(String codigoColor) {
        this.codigoColor = codigoColor;
    }

    public int getCantidadEstilo() {
        return cantidadEstilo;
    }

    public void setCantidadEstilo(int cantidadEstilo) {
        this.cantidadEstilo = cantidadEstilo;
    }
}
