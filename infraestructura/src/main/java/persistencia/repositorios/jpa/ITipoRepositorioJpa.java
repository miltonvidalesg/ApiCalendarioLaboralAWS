package calendariolaboral.api.infraestructura.persistencia.repositorios.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import calendariolaboral.api.infraestructura.persistencia.entidades.*;

@Repository
public interface ITipoRepositorioJpa extends JpaRepository<TipoEntidad, Integer> {

    @Query("SELECT t FROM TipoEntidad t WHERE t.tipo LIKE %?1% ORDER BY t.tipo ASC")
    List<TipoEntidad> buscar(String tipo);

}
