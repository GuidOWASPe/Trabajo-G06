package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demo.entities.Item;

import java.util.List;

@Repository
public interface IItemRepository extends JpaRepository<Item, Integer> {
    @Query(value = "SELECT nombre_item, nr_usos\n" +
            " FROM Item\n" +
            " WHERE nr_usos = (SELECT MAX(nr_usos) FROM Item);",nativeQuery = true)
    public List<Item> maxNroUsos();
}
