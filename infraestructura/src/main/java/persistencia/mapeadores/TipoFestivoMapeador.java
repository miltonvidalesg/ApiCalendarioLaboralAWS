package calendariolaboral.api.infraestructura.persistencia.mapeadores;

import calendariolaboral.api.dominio.entidades.TipoFestivo;
import calendariolaboral.api.infraestructura.persistencia.entidades.TipoFestivoEntidad;

public class TipoFestivoMapeador {

    public static TipoFestivo toModelo(TipoFestivoEntidad entidad) {
        if (entidad == null) {
            return null;
        }
        return new TipoFestivo(
                entidad.getId(),
                entidad.getTipo()
        );
    }

    public static TipoFestivoEntidad toEntidad(TipoFestivo tipoFestivo) {
        if (tipoFestivo == null) {
            return null;
        }
        return new TipoFestivoEntidad(
                tipoFestivo.getId(),
                tipoFestivo.getTipo()
        );
    }
}
