package calendariolaboral.api.core.servicios;

import java.util.List;
import calendariolaboral.api.dominio.entidades.Calendario;

public interface ICalendarioServicio {
    
    public boolean generar(int idPais, int año);

    public List<Calendario> listar(int idPais, int año);

    

}