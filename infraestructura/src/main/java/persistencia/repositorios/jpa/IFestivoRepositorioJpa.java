package calendariolaboral.api.infraestructura.persistencia.repositorios.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import calendariolaboral.api.infraestructura.persistencia.entidades.*;

@Repository
public interface IFestivoRepositorioJpa extends JpaRepository<FestivoEntidad, Integer> {

    @Query("SELECT f FROM FestivoEntidad f WHERE f.nombre LIKE '%' || ?1 || '%' ORDER BY f.nombre ASC")
    public List<FestivoEntidad> buscar(String nombre);

    @Query("SELECT f FROM FestivoEntidad f WHERE f.pais.id=:idPais ORDER BY f.nombre ASC")
    public List<FestivoEntidad> listarPorPais(int idPais);

}
