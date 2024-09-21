package pe.edu.upc.demo.serviceinterfaces;

import pe.edu.upc.demo.entities.Color;

import java.util.List;

public interface IColorService {
    public List<Color> list();
    public void insert(Color ve);
    public Color listId(int id);
    public void update(Color v);
    public void delete(int id);
}
