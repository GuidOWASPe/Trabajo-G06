package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demo.entities.Comentario;

import java.util.List;

@Repository
public interface IComentarioRepository extends JpaRepository<Comentario, Integer> {

    @Query(value = "SELECT contenido, COUNT(*) AS frecuencia \n" +
            "FROM Comentario \n" +
            "WHERE LOWER(contenido) LIKE '%negativo%' \n" +
            "   OR LOWER(contenido) LIKE '%malo%' \n" +
            "   OR LOWER(contenido) LIKE '%problema%' \n" +
            "   OR LOWER(contenido) LIKE '%decepcionante%' \n" +
            "   OR LOWER(contenido) LIKE '%insuficiente%' \n" +
            "   OR LOWER(contenido) LIKE '%deficiente%' \n" +
            "   OR LOWER(contenido) LIKE '%incompleto%' \n" +
            "   OR LOWER(contenido) LIKE '%incorrecto%' \n" +
            "   OR LOWER(contenido) LIKE '%errado%' \n" +
            "   OR LOWER(contenido) LIKE '%desagradable%' \n" +
            "   OR LOWER(contenido) LIKE '%inaceptable%' \n" +
            "   OR LOWER(contenido) LIKE '%frustrado%' \n" +
            "   OR LOWER(contenido) LIKE '%desilusionado%' \n" +
            "   OR LOWER(contenido) LIKE '%desalentador%' \n" +
            "   OR LOWER(contenido) LIKE '%problemático%' \n" +
            "   OR LOWER(contenido) LIKE '%deficiencias%' \n" +
            "   OR LOWER(contenido) LIKE '%fallos%' \n" +
            "   OR LOWER(contenido) LIKE '%errores%' \n" +
            "   OR LOWER(contenido) LIKE '%carencias%' \n" +
            "   OR LOWER(contenido) LIKE '%falta de%' \n" +
            "   OR LOWER(contenido) LIKE '%no cumple con%' \n" +
            "   OR LOWER(contenido) LIKE '%no satisface%' \n" +
            "   OR LOWER(contenido) LIKE '%no se ajusta a%' \n" +
            "   OR LOWER(contenido) LIKE '%no funciona como se esperaba%' \n" +
            "   OR LOWER(contenido) LIKE '%p%obre%' \n" +
            "   OR LOWER(contenido) LIKE '%bajo%' \n" +
            "   OR LOWER(contenido) LIKE '%mediocre%' \n" +
            "   OR LOWER(contenido) LIKE '%barato%' \n" +
            "   OR LOWER(contenido) LIKE '%mal hecho%' \n" +
            "   OR LOWER(contenido) LIKE '%mal acabado%' \n" +
            "   OR LOWER(contenido) LIKE '%descuidado%' \n" +
            "   OR LOWER(contenido) LIKE '%desgastado%' \n" +
            "   OR LOWER(contenido) LIKE '%roto%' \n" +
            "   OR LOWER(contenido) LIKE '%dañado%' \n" +
            "   OR LOWER(contenido) LIKE '%lento%' \n" +
            "   OR LOWER(contenido) LIKE '%ineficaz%' \n" +
            "   OR LOWER(contenido) LIKE '%incompetente%' \n" +
            "   OR LOWER(contenido) LIKE '%desatento%' \n" +
            "   OR LOWER(contenido) LIKE '%descortez%' \n" +
            "   OR LOWER(contenido) LIKE '%irresponsable%' \n" +
            "   OR LOWER(contenido) LIKE '%falta de profesionalidad%' \n" +
            "   OR LOWER(contenido) LIKE '%defectuoso%' \n" +
            "   OR LOWER(contenido) LIKE '%incompatible%' \n" +
            "   OR LOWER(contenido) LIKE '%inútil%' \n" +
            "   OR LOWER(contenido) LIKE '%inseguro%' \n" +
            "   OR LOWER(contenido) LIKE '%inconveniente%' \n" +
            "   OR LOWER(contenido) LIKE '%no práctico%' \n" +
            "   OR LOWER(contenido) LIKE '%no duradero%' \n" +
            "   OR LOWER(contenido) LIKE '%negativa%' \n" +
            "   OR LOWER(contenido) LIKE '%desagradable%' \n" +
            "   OR LOWER(contenido) LIKE '%frustrante%' \n" +
            "   OR LOWER(contenido) LIKE '%decepcionante%' \n" +
            "GROUP BY contenido\n" +
            "ORDER BY frecuencia DESC;", nativeQuery = true)
    public List<String[]> listarComentariosNegativosFrecuentes();
}
