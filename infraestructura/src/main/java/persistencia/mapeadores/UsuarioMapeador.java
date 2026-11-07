package calendariolaboral.api.infraestructura.persistencia.mapeadores;

import calendariolaboral.api.dominio.entidades.Usuario;
import calendariolaboral.api.infraestructura.persistencia.entidades.UsuarioEntidad;

public class UsuarioMapeador {
    public static Usuario toModelo(UsuarioEntidad entidad) {
        if (entidad == null) {
            return null;
        }
        return new Usuario(
                entidad.getId(),
                entidad.getUsuario(),
                entidad.getNombre(),
                entidad.getClave(),
                entidad.getRoles());
    }

    public static UsuarioEntidad toEntidad(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        return new UsuarioEntidad(
                usuario.getId(),
                usuario.getUsuario(),
                usuario.getNombre(),
                usuario.getClave(),
                usuario.getRoles());
    }
}
