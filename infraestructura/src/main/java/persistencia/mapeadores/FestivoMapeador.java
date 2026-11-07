package calendariolaboral.api.infraestructura.persistencia.mapeadores;

import calendariolaboral.api.dominio.entidades.Festivo;
import calendariolaboral.api.infraestructura.persistencia.entidades.FestivoEntidad;

public class FestivoMapeador {

    public static Festivo toModelo(FestivoEntidad entidad) {
        if (entidad == null) {
            return null;
        }
        return new Festivo(
                entidad.getId(),
                entidad.getNombre(),
                entidad.getDia(),
                entidad.getMes(),
                entidad.getDiasPascua(),
                PaisMapeador.toModelo(entidad.getPais()),
                TipoFestivoMapeador.toModelo(entidad.getTipo())
        );
    }

    public static FestivoEntidad toEntidad(Festivo festivo) {
        if (festivo == null) {
            return null;
        }
        return new FestivoEntidad(
                festivo.getId(),
                festivo.getNombre(),
                festivo.getDia(),
                festivo.getMes(),
                festivo.getDiasPascua(),
                PaisMapeador.toEntidad(festivo.getPais()),
                TipoFestivoMapeador.toEntidad(festivo.getTipo())
        );
    }
}
