package pe.edu.upc.demo.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demo.entities.ItemUsuario;
import pe.edu.upc.demo.entities.Rostro;
import pe.edu.upc.demo.repositories.IItemUsuarioRepository;
import pe.edu.upc.demo.serviceinterfaces.IItemUsuarioService;

import java.util.List;

@Service
public class ItemUsuarioServiceImplement implements IItemUsuarioService {

    @Autowired
    private IItemUsuarioRepository iR;

    @Override
    public List<ItemUsuario> list() {
        return iR.findAll();
    }

    @Override
    public void insert(ItemUsuario iu) {
        iR.save(iu);
    }

    @Override
    public ItemUsuario listId(int id) {
        return iR.findById(id).orElse(new ItemUsuario());
    }

    @Override
    public void update(ItemUsuario iu) {
        iR.save(iu);
    }

    @Override
    public void delete(int id) {
        iR.deleteById(id);
    }

    @Override
    public List<String[]> ItemsPorNroUso() {
        return iR.ItemsPorNroUso();
    }
}