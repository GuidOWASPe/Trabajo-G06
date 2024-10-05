package pe.edu.upc.demo.serviceinterfaces;

import pe.edu.upc.demo.entities.Rol;

import java.util.List;

public interface IRolService {
    public List<Rol> list();
    public void insert(Rol Rl);
    public Rol listId(int id);
    public void update(Rol Rl);
    public void delete(int id);
}
