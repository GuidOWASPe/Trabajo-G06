package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demo.entities.Estilo;

import java.util.List;

@Repository
public interface IEstiloRepository extends JpaRepository<Estilo,Integer> {

    @Query(value = " SELECT \n" +
            "    F.nombre_forma AS Nombre_Forma,\n" +
            "    C.nombre_color AS Codigo_Color,\n" +
            "    COUNT(E.id_estilo) AS Cantidad_Estilos\n" +
            " FROM     Estilo E\n" +
            " LEFT JOIN Rostro R\n" +
            " ON E.id_rostro = R.id_rostro\n" +
            " LEFT JOIN Forma F\n" +
            " ON R.id_forma = F.id_forma\n" +
            " RIGHT JOIN Color C\n" +
            " ON E.id_color = C.id_color\n" +
            " GROUP BY (F.nombre_forma,C.nombre_color)", nativeQuery = true)
    public List<String[]> cantidadEstiloColorForma();
}
