package calendariolaboral.api.presentacion.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import calendariolaboral.api.dominio.entidades.*;
import calendariolaboral.api.core.servicios.*;

@RestController
@RequestMapping("/api/TipoFestivos")
public class TipoFestivoControlador {

    private ITipoFestivoServicio servicio;

    public TipoFestivoControlador(ITipoFestivoServicio servicio) {
        this.servicio = servicio;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<TipoFestivo> listar() {
        return servicio.listar();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public TipoFestivo obtener(@PathVariable int id) {
        return servicio.obtener(id);
    }

    @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
    public List<TipoFestivo> buscar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public TipoFestivo agregar(@RequestBody TipoFestivo TipoFestivo) {
        return servicio.agregar(TipoFestivo);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public TipoFestivo modificar(@RequestBody TipoFestivo TipoFestivo) {
        return servicio.modificar(TipoFestivo);
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable int id) {
        return servicio.eliminar(id);
    }

}