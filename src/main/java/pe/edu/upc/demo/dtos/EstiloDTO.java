package pe.edu.upc.demo.dtos;
import pe.edu.upc.demo.entities.Item;
import pe.edu.upc.demo.entities.Rostro;

public class EstiloDTO {

    private int idEstilo;

    private String Nombre;

    private Rostro ro;

    private String CodigoColor;

    private Item it;

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
