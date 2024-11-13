package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demo.entities.Comentario;

import java.util.List;

@Repository
public interface IComentarioRepository extends JpaRepository<Comentario, Integer> {

    @Query(value = " SELECT\n" +
            "    CASE \n" +
            "        WHEN contenido LIKE '%malo%' THEN 'malo'\n" +
            "        WHEN contenido LIKE '%negativo%' THEN 'negativo'\n" +
            "        WHEN contenido LIKE '%problema%' THEN 'problema'\n" +
            "    END AS palabra_clave,\n" +
            "    COUNT(*) AS frecuencia\n" +
            " FROM Comentario\n" +
            " WHERE contenido LIKE '%malo%' OR contenido LIKE '%negativo%' OR contenido LIKE '%problema%'\n" +
            " GROUP BY palabra_clave\n" +
            " ORDER BY frecuencia DESC;", nativeQuery = true)
    public List<String[]> listarComentariosNegativosFrecuentes();
}
