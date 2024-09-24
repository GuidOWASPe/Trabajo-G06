package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demo.entities.ItemUsuario;

import java.util.List;

@Repository
public interface IItemUsuarioRepository extends JpaRepository<ItemUsuario, Integer> {
    @Query(value = "SELECT I.nombre_item, COUNT(IU.id_item) AS nr_usos\n" +
            " FROM item_usuario IU\n" +
            " JOIN item I ON IU.id_item = I.id_item\n" +
            " GROUP BY I.nombre_item\n" +
            " ORDER BY nr_usos DESC;\n",nativeQuery = true)
    public List<String []> ItemsPorNroUso();
}
