package pe.edu.upc.demo.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demo.entities.Rol;
import pe.edu.upc.demo.repositories.IRolRepository;
import pe.edu.upc.demo.serviceinterfaces.IRolService;

import java.util.List;
@Service
public class RolServiceImplement implements IRolService {

    @Autowired
    private IRolRepository Rl;
    @Override
    public List<Rol> list() {return Rl.findAll();}
    @Override
    public void insert(Rol v) {Rl.save(v);}

    @Override
    public Rol listId(int id) {return Rl.findById(id).orElse(new Rol());}

    @Override
    public void update(Rol v) {
        Rl.save(v);
    }

    @Override
    public void delete(int id) {Rl.deleteById(id);}
}
