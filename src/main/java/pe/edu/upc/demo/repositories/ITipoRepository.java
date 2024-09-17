package pe.edu.upc.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demo.entities.Tipo;

import java.util.List;

@Repository
public interface ITipoRepository extends JpaRepository<Tipo,Integer> {

}
