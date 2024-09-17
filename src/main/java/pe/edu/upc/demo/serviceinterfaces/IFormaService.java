package pe.edu.upc.demo.serviceinterfaces;

import pe.edu.upc.demo.entities.Forma;

import java.util.List;

public interface IFormaService {

    public List<Forma> list();
    public void insert(Forma ve);
    public Forma listId(int id);
    public void update(Forma v);
    public void delete(int id);
}
