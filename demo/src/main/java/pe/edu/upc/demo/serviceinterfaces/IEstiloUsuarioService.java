package pe.edu.upc.demo.serviceinterfaces;

import pe.edu.upc.demo.entities.EstiloUsuario;

import java.util.List;

public interface IEstiloUsuarioService {
    public List<EstiloUsuario> list();
    public void insert(EstiloUsuario eU);
    public EstiloUsuario listId(int id);
    public void update(EstiloUsuario v);
    public void delete(int id);
    public List<String[]> estiloUsuarioConPC();
}
