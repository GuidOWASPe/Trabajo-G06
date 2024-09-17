package pe.edu.upc.demo.dtos;

public class ItemsMasUsadosDTO {

    private String nombreItem;
    private int nrUsos;

    public int getNrUsos() {
        return nrUsos;
    }

    public void setNrUsos(int nrUsos) {
        this.nrUsos = nrUsos;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

}
