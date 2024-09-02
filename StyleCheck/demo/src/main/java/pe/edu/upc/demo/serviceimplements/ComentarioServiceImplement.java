package pe.edu.upc.demo.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demo.entities.Comentario;
import pe.edu.upc.demo.entities.Usuario;
import pe.edu.upc.demo.repositories.IComentarioRepository;
import pe.edu.upc.demo.serviceinterfaces.IComentarioService;

import java.util.List;

@Service
public class ComentarioServiceImplement implements IComentarioService {
    @Autowired
    private IComentarioRepository cT;

    @Override
    public List<Comentario> list() {
        return cT.findAll();
    }
    @Override
    public void insert(Comentario c){
        cT.save(c);
    }
    @Override
    public Comentario listId(int id) {return cT.findById(id).orElse(new Comentario());}
    @Override
    public void update(Comentario c){
        cT.save(c);
    }

    @Override
    public void delete(int id){
        cT.deleteById(id);
    }
}