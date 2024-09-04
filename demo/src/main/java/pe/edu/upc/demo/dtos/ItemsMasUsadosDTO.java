package pe.edu.upc.demo.dtos;

public class ItemsMasUsadosDTO {

    private String nombreItem;
    private int nusos;

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public int getNusos() {
        return nusos;
    }

    public void setNusos(int nusos) {
        this.nusos = nusos;
    }
}
