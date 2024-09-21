package pe.edu.upc.demo.serviceinterfaces;

import pe.edu.upc.demo.entities.Rol;

import java.util.List;

public interface IRolService {
    public List<Rol> list();
    public void insert(Rol Rl);
    public Rol listId(Long id);
    public void update(Rol Rl);
    public void delete(Long id);
    public List<Rol> findByNombre(String nombre);
}
