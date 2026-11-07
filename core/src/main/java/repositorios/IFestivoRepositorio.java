package calendariolaboral.api.core.repositorios;

import java.util.List;
import java.util.Optional;
import calendariolaboral.api.dominio.entidades.Festivo;

public interface IFestivoRepositorio {

    List<Festivo> listar();

    List<Festivo> listarPorPais(int idPais);

    Optional<Festivo> obtenerPorId(int id);

    List<Festivo> buscarPorNombre(String nombre);

    Festivo guardar(Festivo festivo);

    boolean eliminar(int id);
}
