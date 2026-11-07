package calendariolaboral.api.core.repositorios;

import java.util.List;
import java.time.LocalDate;

import calendariolaboral.api.dominio.entidades.Calendario;

public interface ICalendarioRepositorio {

    List<Calendario> listarPorAño(int idPais, int año);

    Calendario obtener(int idPais, LocalDate fecha);

    Calendario guardar(Calendario calendario);
}
