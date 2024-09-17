package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demo.entities.Comentario;

import java.util.List;

@Repository
public interface IComentarioRepository extends JpaRepository<Comentario, Integer> {

    @Query(value = " SELECT contenido, COUNT(*) AS frecuencia\n" +
            " FROM Comentario\n" +
            " WHERE contenido LIKE '%negativo%' OR contenido LIKE '%malo%' OR contenido LIKE '%problema%'\n" +
            " GROUP BY contenido\n" +
            " ORDER BY frecuencia DESC;", nativeQuery = true)
    public List<String[]> listarComentariosNegativosFrecuentes();
}
