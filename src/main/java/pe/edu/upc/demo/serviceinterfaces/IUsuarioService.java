package pe.edu.upc.demo.serviceinterfaces;

import pe.edu.upc.demo.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> list();
    public void insert(Usuario us);
    public Usuario listId(int id);
    public void update(Usuario u);
    public void delete(int id);
    public List<Usuario> UsuariosPorPais();
    public List<String[]> cantidadUsuarioEdadGenero();
    public List<String []> usuariosporgeneroservice();
    public List<String []> mesderegistrosusuarios();
    public List<String[]>cantidadEstilosPorUsuario();
    public List<String[]> PaisesPorUsuario();
}
