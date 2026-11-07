package calendariolaboral.api.aplicacion.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import calendariolaboral.api.core.servicios.*;
import calendariolaboral.api.dominio.entidades.*;
import calendariolaboral.api.dominio.dtos.*;
import calendariolaboral.api.core.repositorios.*;
import calendariolaboral.api.aplicacion.seguridad.*;

@Service
public class UsuarioServicio implements IUsuarioServicio {

    @Autowired
    private IUsuarioRepositorio repositorio;

    @Autowired
    private SeguridadServicio servicioSeguridad;

    @Override
    public UsuarioLoginDto login(String nombreUsuario, String clave) {
        Usuario usuarioObtenido = repositorio.login(nombreUsuario, clave);
        UsuarioLoginDto userLoginResponseDto = new UsuarioLoginDto(usuarioObtenido);
        if (usuarioObtenido != null) {
            userLoginResponseDto.setToken(servicioSeguridad.generarToken(nombreUsuario));
        }
        return userLoginResponseDto;
    }

    @Override
    public List<Usuario> listar() {
        return repositorio.listar();
    }

    @Override
    public Usuario obtener(int id) {
        return repositorio.obtenerPorId(id).orElse(null);
    }

    @Override
    public List<Usuario> buscar(String nombre) {
        return repositorio.buscarPorNombre(nombre);
    }

    @Override
    public Usuario agregar(Usuario usuario) {
        usuario.setId(0);
        return repositorio.guardar(usuario);
    }

    @Override
    public Usuario modificar(Usuario usuario) {
        var usuarioEncontrado = repositorio.obtenerPorId(usuario.getId());
        return usuarioEncontrado.isEmpty() ? null : repositorio.guardar(usuario);
    }

    @Override
    public boolean eliminar(int id) {
        return repositorio.eliminar(id);
    }

}
