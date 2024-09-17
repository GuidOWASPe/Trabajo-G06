package pe.edu.upc.demo.serviceinterfaces;

import pe.edu.upc.demo.entities.Tipo;

import java.util.List;

public interface ITipoService {

    public List<Tipo>list();
    public void insert(Tipo ve);
    public Tipo listId(int id);
    public void update(Tipo v);
    public void delete(int id);

}
