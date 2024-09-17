package pe.edu.upc.demo.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demo.entities.EstiloItem;
import pe.edu.upc.demo.repositories.IEstiloItemRepository;
import pe.edu.upc.demo.serviceinterfaces.IEstiloItemService;

import java.util.List;

@Service
public class EstiloItemServiceImplement implements IEstiloItemService {
    @Autowired
    private IEstiloItemRepository eS;

    @Override
    public List<EstiloItem> list(){return eS.findAll();}

    @Override
    public void insert(EstiloItem e) {eS.save(e);}
    @Override
    public EstiloItem listId(int id) {
        return eS.findById(id).orElse(new EstiloItem());}

    @Override
    public void update(EstiloItem e) {
        eS.save(e);
    }

    @Override
    public void delete(int id) {
        eS.deleteById(id);
    }
}
