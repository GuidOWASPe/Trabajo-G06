package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demo.entities.ItemUsuario;

import java.util.List;

@Repository
public interface IItemUsuarioRepository extends JpaRepository<ItemUsuario, Integer> {
    @Query(value = "SELECT I.nombreItem, COUNT(IU.idItem) AS Usos\n" +
            " FROM ItemUsuario IU\n" +
            " JOIN Item I ON IU.idItem = I.idItem\n" +
            " GROUP BY I.nombreItem\n" +
            " ORDER BY Usos DESC;\n",nativeQuery = true)
    public List<String []> itemsmasusados();
}
