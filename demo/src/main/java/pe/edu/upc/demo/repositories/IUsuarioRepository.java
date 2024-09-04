package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.demo.entities.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {
    @Query(value = "SELECT u.sexo_usuario AS Genero,COUNT(u.id_usuario) AS CantidadUsuarios,\n" +
            " ROUND((COUNT(u.id_usuario) * 100.0 / (SELECT COUNT(*) FROM usuario)), 2) \n" +
            " AS Porcentaje\n" +
            " FROM usuario U\n" +
            " GROUP BY U.sexo_usuario\n" +
            " ORDER BY CantidadUsuarios DESC;\n",nativeQuery = true)
     public List<String []> usuariosporgenero();


    @Query(value = "SELECT TO_CHAR(fecha_registro_usuario, 'YYYY-MM') AS MesRegistro,\n" +
            " COUNT(id_usuario) AS UsuariosRegistrados,\n" +
            " ROUND((COUNT(id_usuario) * 100.0 / (SELECT COUNT(*)\n" +
            " FROM usuario)), 2) AS Porcentaje\n" +
            " FROM usuario\n" +
            " GROUP BY MesRegistro\n" +
            " ORDER BY MesRegistro DESC;\n",nativeQuery = true)
    public  List<String []> mesderegistrosusuarios();

}

