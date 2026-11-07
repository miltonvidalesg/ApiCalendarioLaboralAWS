package calendariolaboral.api.core.repositorios;

import java.util.List;
import java.util.Optional;

import calendariolaboral.api.dominio.entidades.TipoFestivo;

public interface ITipoFestivoRepositorio {

    List<TipoFestivo> listar();

    Optional<TipoFestivo> obtenerPorId(int id);

    List<TipoFestivo> buscarPorNombre(String nombre);

    TipoFestivo guardar(TipoFestivo tipo);

    boolean eliminar(int id);
}
