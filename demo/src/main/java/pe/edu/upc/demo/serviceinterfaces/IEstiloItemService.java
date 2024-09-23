package pe.edu.upc.demo.serviceinterfaces;
import pe.edu.upc.demo.entities.EstiloItem;

import java.util.List;
public interface IEstiloItemService {
    public List<EstiloItem> list();
    public void insert(EstiloItem estiloItem);
    public EstiloItem listId(int id);
    public void update(EstiloItem e);
    public void delete(int id);
}
