package calendariolaboral.api.core.repositorios;

import java.util.List;
import java.util.Optional;

import calendariolaboral.api.dominio.entidades.Usuario;
import calendariolaboral.api.dominio.dtos.UsuarioLoginDto;

public interface IUsuarioRepositorio {

    Usuario login(String nombreUsuario, String clave);

    List<Usuario> listar();

    Optional<Usuario> obtenerPorId(int id);

    Optional<Usuario> obtener(String usuario);

    List<Usuario> buscarPorNombre(String nombre);

    Usuario guardar(Usuario usuario);

    boolean eliminar(int id);
}
