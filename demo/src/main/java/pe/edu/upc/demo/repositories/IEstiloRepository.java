package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demo.entities.Estilo;

import java.util.List;

@Repository
public interface IEstiloRepository extends JpaRepository<Estilo,Integer> {

    @Query(value = " SELECT u.nickname_usuario AS Usuario,\n" +
            " \tCOUNT(e.id_estilo) AS cantidad_estilos\n" +
            " FROM Estilo e\n" +
            " LEFT JOIN Rostro r\n" +
            " \tON e.id_rostro = r.id_rostro\n" +
            " LEFT JOIN Usuario u\n" +
            " \tON r.id_usuario = u.id_usuario\n" +
            " GROUP BY (u.nickname_usuario)",nativeQuery = true)
    public List<String[]> EstilosPorUsuarios();
}
