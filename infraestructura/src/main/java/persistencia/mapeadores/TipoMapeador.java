package calendariolaboral.api.infraestructura.persistencia.mapeadores;

import calendariolaboral.api.dominio.entidades.Tipo;
import calendariolaboral.api.infraestructura.persistencia.entidades.TipoEntidad;

public class TipoMapeador {

    public static Tipo toModelo(TipoEntidad entidad) {
        if (entidad == null) {
            return null;
        }
        return new Tipo(
                entidad.getId(),
                entidad.getTipo()
        );
    }

    public static TipoEntidad toEntidad(Tipo tipo) {
        if (tipo == null) {
            return null;
        }
        return new TipoEntidad(
                tipo.getId(),
                tipo.getTipo()
        );
    }
}
