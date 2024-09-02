package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.demo.entities.Usuario;
import org.springframework.stereotype.Repository;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {
}
