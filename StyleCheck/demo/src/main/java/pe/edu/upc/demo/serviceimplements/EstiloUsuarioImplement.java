package pe.edu.upc.demo.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demo.entities.EstiloUsuario;
import pe.edu.upc.demo.repositories.IEstiloUsuarioRepository;
import pe.edu.upc.demo.serviceinterfaces.IEstiloUsuarioService;

import java.util.List;

@Service
public class EstiloUsuarioImplement implements IEstiloUsuarioService {
    @Autowired
    private IEstiloUsuarioRepository eR;

    @Override
    public List<EstiloUsuario> list() {
        return eR.findAll();
    }

    @Override
    public void insert(EstiloUsuario eU) {
        eR.save(eU);
    }

    @Override
    public EstiloUsuario listId(int id) {
        return eR.findById(id).orElse(new EstiloUsuario());
    }

    @Override
    public void update(EstiloUsuario v) {
        eR.save(v);
    }

    @Override
    public void delete(int id) {
        eR.deleteById(id);
    }
}
