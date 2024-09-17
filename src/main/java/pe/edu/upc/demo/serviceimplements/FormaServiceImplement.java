package pe.edu.upc.demo.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demo.entities.Forma;
import pe.edu.upc.demo.repositories.IFormaRepository;
import pe.edu.upc.demo.serviceinterfaces.IFormaService;

import java.util.List;

@Service
public class FormaServiceImplement implements IFormaService {

    @Autowired
    private IFormaRepository vR;

    @Override
    public List<Forma> list() {
        return vR.findAll();
    }

    @Override
    public void insert(Forma ve) {
        vR.save(ve);
    }

    @Override
    public Forma listId(int id) {
        return vR.findById(id).orElse(new Forma());

    }

    @Override
    public void update(Forma v) {
        vR.save(v);
    }

    @Override
    public void delete(int id) {
        vR.deleteById(id);
    }
}
