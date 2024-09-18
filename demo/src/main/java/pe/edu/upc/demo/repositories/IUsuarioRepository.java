package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.demo.entities.Usuario;

import java.util.List;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {


    @Query(value = " SELECT pais_usuario AS Pais,\n" +
            " COUNT(pais_usuario) AS Cantidad\n" +
            " FROM usuario WHERE id_rol = 2\n" +
            " GROUP BY pais_usuario",nativeQuery = true)
    public List<Usuario> UsuariosPorPais();

    @Query(value = "SELECT \n" +
            "    CASE\n" +
            "        WHEN EXTRACT(YEAR FROM CURRENT_DATE) - EXTRACT(YEAR FROM fecha_Nacimiento_usuario) BETWEEN 0 AND 18 THEN '0-18'\n" +
            "        WHEN EXTRACT(YEAR FROM CURRENT_DATE) - EXTRACT(YEAR FROM fecha_Nacimiento_usuario) BETWEEN 19 AND 25 THEN '19-25'\n" +
            "        ELSE '26+'\n" +
            "    END AS rango_edad,\n" +
            "    sexo_usuario,\n" +
            "    COUNT(*) AS cantidad_usuarios\n" +
            " FROM Usuario\n" +
            " GROUP BY rango_edad, sexo_usuario\n" +
            " ORDER BY rango_edad, sexo_usuario, cantidad_usuarios DESC;", nativeQuery = true)
    public List<String[]> cantidadUsuarioEdadGenero();

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

    @Query(value ="SELECT u.nickname_usuario AS Usuario,\n" +
            " \tCOUNT(e.id_estilo) AS cantidad_estilos\n" +
            " FROM Estilo e\n" +
            " LEFT JOIN Rostro r\n" +
            " \tON e.id_rostro = r.id_rostro\n" +
            " LEFT JOIN Usuario u\n" +
            " \tON r.id_usuario = u.id_usuario\n" +
            " GROUP BY (u.nickname_usuario)" ,nativeQuery = true)
    public List<String[]>cantidadEstilosPorUsuario();

    @Query(value = "SELECT pais_usuario AS Pais,\n" +
            " COUNT(pais_usuario) AS Cantidad\n" +
            " FROM usuario WHERE id_rol = 2\n" +
            " GROUP BY pais_usuario",nativeQuery = true)
    public List<String[]> PaisesPorUsuario();
    
    public Usuario findOneByUsername(String username);
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);
}
