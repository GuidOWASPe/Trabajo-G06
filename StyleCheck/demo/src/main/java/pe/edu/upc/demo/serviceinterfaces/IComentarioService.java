package pe.edu.upc.demo.serviceinterfaces;

import pe.edu.upc.demo.entities.Comentario;

import java.util.List;

public interface IComentarioService {
    public List<Comentario> list();
    public void insert(Comentario c);
    public Comentario listId(int id);
    public void update(Comentario c);
    public void delete(int id);
}
