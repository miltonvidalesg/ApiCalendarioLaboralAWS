package calendariolaboral.api.infraestructura.persistencia.repositorios;

import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import calendariolaboral.api.dominio.entidades.Calendario;
import calendariolaboral.api.core.repositorios.ICalendarioRepositorio;
import calendariolaboral.api.infraestructura.persistencia.entidades.CalendarioEntidad;
import calendariolaboral.api.infraestructura.persistencia.mapeadores.CalendarioMapeador;
import calendariolaboral.api.infraestructura.persistencia.repositorios.jpa.ICalendarioRepositorioJpa;

@Component
public class CalendarioRepositorio implements ICalendarioRepositorio{

    @Autowired
    private ICalendarioRepositorioJpa repositorio;

    public List<Calendario> listarPorAño(int idPais, int año){
        return repositorio.listarPorAño(idPais, año)
                .stream()
                .map(CalendarioMapeador::toModelo)
                .collect(Collectors.toList());
    }

    @Override
    public Calendario obtener(int idPais, LocalDate fecha){
        return CalendarioMapeador.toModelo(repositorio.obtener(idPais, fecha));
    }

    @Override
    public Calendario guardar(Calendario calendario) {
        CalendarioEntidad calendarioEntidad = CalendarioMapeador.toEntidad(calendario);
        CalendarioEntidad guardado = repositorio.save(calendarioEntidad);
        return CalendarioMapeador.toModelo(guardado);
    }

}
