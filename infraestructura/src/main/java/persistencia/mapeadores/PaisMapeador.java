package calendariolaboral.api.infraestructura.persistencia.mapeadores;

import calendariolaboral.api.dominio.entidades.Pais;
import calendariolaboral.api.infraestructura.persistencia.entidades.PaisEntidad;

public class PaisMapeador {

    public static Pais toModelo(PaisEntidad entidad) {
        if (entidad == null) {
            return null;
        }
        return new Pais(
                entidad.getId(),
                entidad.getNombre()
            );
    }

    public static PaisEntidad toEntidad(Pais pais) {
        if (pais == null) {
            return null;
        }
        return new PaisEntidad(
                pais.getId(),
                pais.getNombre()
            );
    }
}
