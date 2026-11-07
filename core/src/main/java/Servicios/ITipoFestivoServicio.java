package calendariolaboral.api.core.servicios;

import java.util.List;
import calendariolaboral.api.dominio.entidades.*;

public interface ITipoFestivoServicio {

   public List<TipoFestivo> listar();

    public TipoFestivo obtener(int id);

    public List<TipoFestivo> buscar(String nombre);

    public TipoFestivo agregar(TipoFestivo TipoFestivo);

    public TipoFestivo modificar(TipoFestivo TipoFestivo);

    public boolean eliminar(int id);
}
