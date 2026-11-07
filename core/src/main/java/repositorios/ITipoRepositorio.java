package calendariolaboral.api.core.repositorios;

import java.util.List;
import java.util.Optional;

import calendariolaboral.api.dominio.entidades.Tipo;

public interface ITipoRepositorio {

    List<Tipo> listar();

    Optional<Tipo> obtenerPorId(int id);

    List<Tipo> buscarPorNombre(String nombre);

    Tipo guardar(Tipo tipo);

    boolean eliminar(int id);
}
