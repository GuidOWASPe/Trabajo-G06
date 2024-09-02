package pe.edu.upc.demo.serviceinterfaces;

import pe.edu.upc.demo.entities.Rostro;

import java.util.List;

public interface IRostroService {
    public List<Rostro> list();
    public void insert(Rostro r);
    public Rostro listId(int id);
    public void update(Rostro r);
    public void delete(int id);
}
