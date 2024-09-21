package pe.edu.upc.demo.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demo.entities.Color;
import pe.edu.upc.demo.repositories.IColorRepository;
import pe.edu.upc.demo.serviceinterfaces.IColorService;

import java.util.List;
@Service
public class ColorServiceImplement implements IColorService {
    
    @Autowired
    private IColorRepository vR;
    @Override
    public List<Color> list() {
        return vR.findAll();
    }
    @Override
    public void insert(Color ve) {
        vR.save(ve);
    }

    @Override
    public Color listId(int id) {return vR.findById(id).orElse(new Color());}

    @Override
    public void update(Color v) {
        vR.save(v);
    }

    @Override
    public void delete(int id) {
        vR.deleteById(id);
    }
}
