package pe.edu.upc.demo.serviceinterfaces;

import pe.edu.upc.demo.entities.ItemUsuario;
import pe.edu.upc.demo.entities.Rostro;

import java.util.List;

public interface IItemUsuarioService {
    public List<ItemUsuario> list();
    public void insert(ItemUsuario iu);
    public ItemUsuario listId(int id);
    public void update(ItemUsuario iu);
    public void delete(int id);
    public List<String []> itemsmasusados();
}
