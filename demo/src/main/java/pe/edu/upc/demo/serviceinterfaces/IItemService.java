package pe.edu.upc.demo.serviceinterfaces;

import pe.edu.upc.demo.entities.Item;

import java.util.List;

public interface IItemService {
    public List<Item> list();
    public void insert(Item ti);
    public Item listId(int id);
    public void update(Item t);
    public void delete(int id);
}
