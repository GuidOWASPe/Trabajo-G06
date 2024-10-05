package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.demo.entities.EstiloItem;

public interface IEstiloItemRepository extends JpaRepository<EstiloItem, Integer> {
}
