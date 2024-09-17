package pe.edu.upc.demo.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demo.entities.Tipo;
import pe.edu.upc.demo.repositories.ITipoRepository;
import pe.edu.upc.demo.serviceinterfaces.ITipoService;

import java.util.List;
@Service
public class TipoServiceImplement implements ITipoService{

    @Autowired
    private ITipoRepository tR;
    @Override
    public List<Tipo> list() {
        return tR.findAll();
    }
    @Override
    public void insert(Tipo ve) {
        tR.save(ve);
    }

    @Override
    public Tipo listId(int id) {return tR.findById(id).orElse(new Tipo());}

    @Override
    public void update(Tipo v) {
        tR.save(v);
    }

    @Override
    public void delete(int id) {
        tR.deleteById(id);
    }
}
