package pe.edu.upc.demo.entities;
import jakarta.persistence.*;

@Entity
@Table(name="EstiloItem")

public class EstiloItem {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idExI;
    @ManyToOne
    @JoinColumn(name="idEstilo")
    private Estilo estilo;
    @ManyToOne
    @JoinColumn(name="idItem")
    private Item item;

    public EstiloItem() {
    }

    public EstiloItem(int idExI, Item item, Estilo estilo) {
        this.idExI = idExI;
        this.item = item;
        this.estilo = estilo;
    }

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
