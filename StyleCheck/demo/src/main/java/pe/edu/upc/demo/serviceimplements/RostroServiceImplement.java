package pe.edu.upc.demo.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demo.entities.Rostro;
import pe.edu.upc.demo.repositories.IRostroRepository;
import pe.edu.upc.demo.serviceinterfaces.IRostroService;

import java.util.List;

@Service
public class RostroServiceImplement implements IRostroService {

    @Autowired
    private IRostroRepository rR;

    @Override
    public List<Rostro> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Rostro t) {
        rR.save(t);
    }

    @Override
    public Rostro listId(int id) {
        return rR.findById(id).orElse(new Rostro());
    }

    @Override
    public void update(Rostro r) {
        rR.save(r);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }
}