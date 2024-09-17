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
    private IUsuarioRepository uS;

    @Override
    public List<Usuario> list() {
        return uS.findAll();
    }

    @Override
    public void insert(Usuario t) {
        uS.save(t);
    }

    @Override
    public Usuario listId(int id) {return uS.findById(id).orElse(new Usuario());}

    @Override
    public void update(Usuario v) {
        uS.save(v);
    }

    @Override
    public void delete(int id) {
        uS.deleteById(id);
    }
    @Override
    public List<Usuario> UsuariosPorPais() {
        return uS.UsuariosPorPais();
    }
    public List<String[]> cantidadUsuarioEdadGenero() {return uS.cantidadUsuarioEdadGenero();}

    @Override
    public List<String[]> usuariosporgeneroservice() {
        return uS.usuariosporgenero();
    }

    @Override
    public List<String[]> mesderegistrosusuarios() {
        return uS.mesderegistrosusuarios();
    }

    @Override
    public List<String[]> cantidadEstilosPorUsuario() {
        return uS.cantidadEstilosPorUsuario();
    }

    @Override
    public List<String[]> PaisesPorUsuario() {
        return uS.PaisesPorUsuario();
    }
}