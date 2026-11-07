package calendariolaboral.api.infraestructura.persistencia.repositorios.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import calendariolaboral.api.infraestructura.persistencia.entidades.*;

@Repository
public interface IPaisRepositorioJpa extends JpaRepository<PaisEntidad, Integer> {

    @Query("SELECT p FROM PaisEntidad p WHERE p.nombre LIKE '%' || ?1 || '%'")
    List<PaisEntidad> buscar(String nombre);
}
