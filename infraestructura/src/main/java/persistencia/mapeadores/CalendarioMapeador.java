package calendariolaboral.api.infraestructura.persistencia.mapeadores;

import calendariolaboral.api.dominio.entidades.Calendario;
import calendariolaboral.api.infraestructura.persistencia.entidades.CalendarioEntidad;

public class CalendarioMapeador {

    public static Calendario toModelo(CalendarioEntidad entidad) {
        if (entidad == null) {
            return null;
        }
        return new Calendario(
                entidad.getId(),
                entidad.getFecha(),
                TipoMapeador.toModelo(entidad.getTipo()),
                entidad.getDescripcion(),
                PaisMapeador.toModelo(entidad.getPais())
        );
    }

    public static CalendarioEntidad toEntidad(Calendario calendario) {
        if (calendario == null) {
            return null;
        }
        return new CalendarioEntidad(
                calendario.getId(),
                calendario.getFecha(),
                TipoMapeador.toEntidad(calendario.getTipo()),
                calendario.getDescripcion(),
                PaisMapeador.toEntidad(calendario.getPais())
        );
    }

}
