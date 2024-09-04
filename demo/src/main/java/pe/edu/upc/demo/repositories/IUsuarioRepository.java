package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.demo.entities.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {

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
}
