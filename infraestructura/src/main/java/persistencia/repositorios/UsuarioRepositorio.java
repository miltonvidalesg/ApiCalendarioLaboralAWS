package calendariolaboral.api.infraestructura.persistencia.repositorios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import calendariolaboral.api.dominio.entidades.Usuario;
import calendariolaboral.api.core.repositorios.IUsuarioRepositorio;
import calendariolaboral.api.infraestructura.persistencia.entidades.UsuarioEntidad;
import calendariolaboral.api.infraestructura.persistencia.mapeadores.UsuarioMapeador;
import calendariolaboral.api.infraestructura.persistencia.repositorios.jpa.IUsuarioRepositorioJpa;

@Component
public class UsuarioRepositorio implements IUsuarioRepositorio {

    @Autowired
    private IUsuarioRepositorioJpa repositorio;

    @Override
    public Usuario login(String nombreUsuario, String clave) {
        UsuarioEntidad entidad = repositorio.login(nombreUsuario, clave);

        if (entidad == null) {
            return null;
        }

        return UsuarioMapeador.toModelo(entidad);
    }

    @Override
    public List<Usuario> listar() {
        return repositorio.findAll()
                .stream()
                .map(UsuarioMapeador::toModelo)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Usuario> obtenerPorId(int id) {
        return repositorio.findById(id)
                .map(UsuarioMapeador::toModelo);
    }

    @Override
    public Optional<Usuario> obtener(String usuario) {
        UsuarioEntidad entidad = repositorio.obtener(usuario);

        if (entidad == null) {
            return Optional.empty();
        }

        return Optional.of(UsuarioMapeador.toModelo(entidad));
    }

    @Override
    public List<Usuario> buscarPorNombre(String nombre) {
        return repositorio.buscar(nombre)
                .stream()
                .map(UsuarioMapeador::toModelo)
                .collect(Collectors.toList());
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        UsuarioEntidad usuarioEntidad = UsuarioMapeador.toEntidad(usuario);
        UsuarioEntidad guardado = repositorio.save(usuarioEntidad);
        return UsuarioMapeador.toModelo(guardado);
    }

    @Override
    public boolean eliminar(int id) {
        try {
            if (repositorio.existsById(id)) {
                repositorio.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }
}
