package pe.edu.upc.demo.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demo.entities.Estilo;
import pe.edu.upc.demo.repositories.IEstiloRepository;
import pe.edu.upc.demo.serviceinterfaces.IEstiloService;

import java.util.List;

@Service
public class EstiloServiceImplement implements IEstiloService {
    @Autowired
    private IEstiloRepository eR;

    @Override
    public List<Estilo> list() {
        return eR.findAll();
    }

    @Override
    public void insert(Estilo estilo) {
        eR.save(estilo);
    }
    @Override
    public Estilo listId(int id) {return eR.findById(id).orElse(new Estilo());}

    @Override
    public void update(Estilo v) {
        eR.save(v);
    }

    @Override
    public void delete(int id) {
        eR.deleteById(id);
    }

    @Override
    public List<String[]> EstilosPorUsuarios() {
        return eR.EstilosPorUsuarios();
    }
    public List<String[]> cantidadEstiloColorForma() {return eR.cantidadEstiloColorForma();}

}
