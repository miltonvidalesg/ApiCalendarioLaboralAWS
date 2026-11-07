package calendariolaboral.api.core.repositorios;

import java.util.List;
import java.util.Optional;
import calendariolaboral.api.dominio.entidades.Pais;

public interface IPaisRepositorio {

    List<Pais> listar();

    Optional<Pais> obtenerPorId(int id);

    List<Pais> buscarPorNombre(String nombre);

    Pais guardar(Pais pais);

    boolean eliminar(int id);

}