package calendariolaboral.api.presentacion.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import calendariolaboral.api.core.servicios.ICalendarioServicio;
import calendariolaboral.api.dominio.entidades.Calendario;

@RestController
@RequestMapping("/api/calendario")
public class CalendarioControlador {
    
    @Autowired
    private ICalendarioServicio servicio;

    @RequestMapping(value = "/generar/{idPais}/{año}", method = RequestMethod.GET)
    public boolean generar(@PathVariable int idPais, @PathVariable int año) {
        return servicio.generar(idPais, año);
    }

    @RequestMapping(value = "/listar/{idPais}/{año}", method = RequestMethod.GET)
    public List<Calendario> listar(@PathVariable int idPais, @PathVariable int año) {
        return servicio.listar(idPais, año);
    }
}
