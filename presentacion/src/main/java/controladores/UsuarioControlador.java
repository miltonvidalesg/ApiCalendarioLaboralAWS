package calendariolaboral.api.aplicacion.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import calendariolaboral.api.dominio.dtos.*;
import calendariolaboral.api.dominio.entidades.*;
import calendariolaboral.api.core.servicios.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControlador {

    @Autowired
    private IUsuarioServicio servicio;

    @RequestMapping(value = "/validar/{nombreUsuario}/{clave}", method = RequestMethod.GET)
    public UsuarioLoginDto login(@PathVariable String nombreUsuario, @PathVariable String clave) {
        return servicio.login(nombreUsuario, clave);
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Usuario> listar() {
        return servicio.listar();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Usuario obtener(@PathVariable int id) {
        return servicio.obtener(id);
    }

    @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
    public List<Usuario> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Usuario crear(@RequestBody Usuario usuario) {
        return servicio.agregar(usuario);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Usuario actualizar(@RequestBody Usuario usuario) {
        return servicio.modificar(usuario);
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable int id) {
        return servicio.eliminar(id);
    }

}
