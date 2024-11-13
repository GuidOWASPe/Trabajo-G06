package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demo.entities.EstiloUsuario;

import java.util.List;

@Repository
public interface IEstiloUsuarioRepository extends JpaRepository<EstiloUsuario, Integer> {
    @Query(value = "SELECT \n" +
            "               EU.id_estilo_usuario, \n" +
            "                U.username AS Usuarios, \n" +
            "                E.nombre_estilo AS Estilo, \n" +
            "                EU.calificacion_estilo\n" +
            "             FROM \n" +
            "                estilo_usuario EU\n" +
            "             JOIN \n" +
            "                Usuarios U ON EU.id_usuario = U.id_usuario\n" +
            "             JOIN \n" +
            "                Estilo E ON EU.id_estilo = E.id_estilo\n" +
            "             WHERE \n" +
            "                EU.calificacion_estilo = (SELECT MIN(calificacion_estilo) FROM estilo_usuario)",nativeQuery = true)
    public List<String[]> estiloUsuarioConPC();
}
