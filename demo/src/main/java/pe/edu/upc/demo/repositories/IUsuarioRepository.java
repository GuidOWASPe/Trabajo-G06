package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.demo.entities.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Query(value = " SELECT pais_usuario AS Pais,\n" +
            " COUNT(pais_usuario) AS Cantidad\n" +
            " FROM usuario WHERE id_rol = 2\n" +
            " GROUP BY pais_usuario",nativeQuery = true)
    public List<Usuario> UsuariosPorPais();
}
