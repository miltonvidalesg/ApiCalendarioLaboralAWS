package calendariolaboral.api.core.servicios;

import java.time.LocalDate;
import java.util.List;

import calendariolaboral.api.dominio.dtos.FestivoDto;
import calendariolaboral.api.dominio.entidades.*;

public interface IFestivoServicio {

    public List<Festivo> listar();

    public Festivo obtener(int id);

    public List<Festivo> buscar(String nombre);

    public Festivo agregar(Festivo festivo);

    public Festivo modificar(Festivo festivo);

    public boolean eliminar(int id);

    public boolean verificar(int idPais, LocalDate fecha);

    public List<FestivoDto> listar(int idPais, int año);

}
