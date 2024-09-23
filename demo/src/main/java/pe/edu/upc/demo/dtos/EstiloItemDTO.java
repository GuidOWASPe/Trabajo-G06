package pe.edu.upc.demo.dtos;
import pe.edu.upc.demo.entities.Estilo;
import pe.edu.upc.demo.entities.Item;

public class EstiloItemDTO {
    private int idExI;
    private Estilo estilo;
    private Item item;

    public int getIdExI() {
        return idExI;
    }

    public void setIdExI(int idExI) {
        this.idExI = idExI;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
