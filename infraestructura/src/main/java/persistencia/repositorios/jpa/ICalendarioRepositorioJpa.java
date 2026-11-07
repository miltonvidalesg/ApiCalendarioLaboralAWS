package calendariolaboral.api.infraestructura.persistencia.repositorios.jpa;


import java.util.List;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import calendariolaboral.api.infraestructura.persistencia.entidades.*;

public interface ICalendarioRepositorioJpa extends JpaRepository<CalendarioEntidad, Long> {

    @Query("SELECT c FROM CalendarioEntidad c  WHERE year(c.fecha) = :año AND c.pais.id=:idPais")
    public List<CalendarioEntidad> listarPorAño(@Param("idPais") int idPais, @Param("año") int año);

    @Query("SELECT c FROM CalendarioEntidad c WHERE c.fecha = :fecha AND c.pais.id=:idPais")
    public CalendarioEntidad obtener(@Param("idPais") int idPais, @Param("fecha") LocalDate fecha);

}
