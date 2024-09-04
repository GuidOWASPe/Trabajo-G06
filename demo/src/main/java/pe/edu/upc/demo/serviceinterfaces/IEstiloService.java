package pe.edu.upc.demo.serviceinterfaces;

import pe.edu.upc.demo.entities.Estilo;

import java.util.List;

public interface IEstiloService {
    public List<Estilo> list();
    public void insert(Estilo estilo);
    public Estilo listId(int id);
    public void update(Estilo v);
    public void delete(int id);
    public List<String[]> EstilosPorUsuarios();
}
