package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demo.entities.Estilo;

import java.util.List;

@Repository
public interface IEstiloRepository extends JpaRepository<Estilo,Integer> {

    @Query(value = " SELECT\n " +
            "    F.nombre_forma AS Nombre_Forma,\n " +
            "    C.nombre_color AS Codigo_Color,\n " +
            "    COUNT(E.id_estilo) AS Cantidad_Estilos\n " +
            "FROM\n " +
            "    Estilo E\n " +
            "LEFT JOIN\n " +
            "    Rostro R ON E.id_rostro = R.id_rostro\n" +
            "LEFT JOIN\n " +
            "    Forma F ON R.id_forma = F.id_forma\n " +
            "RIGHT JOIN\n " +
            "    Color C ON E.id_color = C.id_color\n " +
            "WHERE\n " +
            "    E.id_estilo = e.id_estilo  \n " +
            "GROUP BY\n " +
            "    F.nombre_forma, C.nombre_color; ", nativeQuery = true)
    public List<String[]> cantidadEstiloColorForma();


    @Query(value = " SELECT u.username AS Usuarios,\n " +
            "             COUNT(e.id_estilo) AS cantidad_estilos\n " +
            "             FROM Estilo e\n " +
            "             LEFT JOIN Rostro r\n " +
            "             ON e.id_rostro = r.id_rostro\n " +
            "             LEFT JOIN Usuarios u\n " +
            "             ON r.id_usuario = u.id_usuario\n " +
            "             GROUP BY (u.username)",nativeQuery = true)
    public List<String[]> cantidadEstilosPorUsuario();
}
