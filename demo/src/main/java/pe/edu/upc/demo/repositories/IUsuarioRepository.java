package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.demo.entities.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {
    @Query(value = "SELECT U.sexo AS Genero,COUNT(U.idUsuario) AS CantidadUsuarios,\n" +
            " ROUND((COUNT(U.idUsuario) * 100.0 / (SELECT COUNT(*) FROM Usuario)), 2) \n" +
            " AS Porcentaje\n" +
            " FROM Usuario U\n" +
            " GROUP BY U.sexo\n" +
            " ORDER BY CantidadUsuarios DESC;\n",nativeQuery = true)
     public List<String []> usuariosporgenero();


    @Query(value = "SELECT TO_CHAR(fechaRegistro, 'YYYY-MM') AS MesRegistro,\n" +
            " COUNT(idUsuario) AS UsuariosRegistrados,\n" +
            " ROUND((COUNT(idUsuario) * 100.0 / (SELECT COUNT(*)\n" +
            " FROM Usuario)), 2) AS Porcentaje\n" +
            " FROM Usuario\n" +
            " GROUP BY MesRegistro\n" +
            " ORDER BY MesRegistro DESC;\n",nativeQuery = true)
    public  List<String []> mesderegistrosusuarios();

}

