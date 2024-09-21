package pe.edu.upc.demo.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demo.entities.Usuario;
import pe.edu.upc.demo.repositories.IUsuarioRepository;
import pe.edu.upc.demo.serviceinterfaces.IUsuarioService;


import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository uR;

    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }

    @Override
    public void insert(Usuario tu) {
        uR.save(tu);
    }

    @Override
    public void update(Usuario v) {
        uR.save(v);
    }

    @Override
    public void delete(Long idUsuario) {
        uR.deleteById(idUsuario);
    }

    @Override
    public Usuario listId(Long idUsuario) {return uR.findById(idUsuario).orElse(new Usuario());}

    public List<String[]> cantidadUsuarioEdadGenero() {return uR.cantidadUsuarioEdadGenero();}

    @Override
    public List<String[]> usuariosporgeneroservice() {
        return uR.usuariosporgenero();
    }

    @Override
    public List<String[]> mesderegistrosusuarios() {
        return uR.mesderegistrosusuarios();
    }

    @Override
    public List<String[]> PaisesPorUsuario() {
        return uR.PaisesPorUsuario();
    }
}
