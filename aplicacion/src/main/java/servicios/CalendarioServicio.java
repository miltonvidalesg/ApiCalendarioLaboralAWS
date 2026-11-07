package calendariolaboral.api.aplicacion.servicios;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import calendariolaboral.api.core.servicios.ICalendarioServicio;
import calendariolaboral.api.core.servicios.IFestivoServicio;
import calendariolaboral.api.core.servicios.IPaisServicio;
import calendariolaboral.api.dominio.dtos.FestivoDto;
import calendariolaboral.api.dominio.entidades.*;
import calendariolaboral.api.core.repositorios.ITipoRepositorio;
import calendariolaboral.api.core.repositorios.ICalendarioRepositorio;

@Service
public class CalendarioServicio implements ICalendarioServicio {


    private List<FestivoDto> festivos = new ArrayList<>();

    @Autowired
    private ITipoRepositorio repositorioTipo;
    @Autowired
    private ICalendarioRepositorio repositorio;
    @Autowired
    private IFestivoServicio festivoServicio;
    @Autowired
    private IPaisServicio paisServicio;


    public static boolean fechasIguales(LocalDate fecha1, LocalDate fecha2) {
        return fecha1.equals(fecha2);
    }

    private boolean esFestivo(LocalDate fechaBuscada) {
        Optional<FestivoDto> festivoEncontrado = festivos.stream()
                .filter(festivo -> fechasIguales(festivo.getFecha(), fechaBuscada))
                .findFirst();
        return festivoEncontrado.isPresent();
    }

    private String obtenerDiaSemana(LocalDate fecha) {
        String[] diasSemana = {
                "Lunes", "Martes", "Miércoles", "Jueves",
                "Viernes", "Sábado", "Domingo"
        };

        DayOfWeek diaSemana = fecha.getDayOfWeek();

        return diasSemana[diaSemana.getValue() - 1];
    }

    private boolean esFinSemana(String nombreDia) {
        List<String> diasFinSemana = new ArrayList<>();
        diasFinSemana.add("Domingo");
        diasFinSemana.add("Sábado");
        return diasFinSemana.contains(nombreDia);
    }

    @Override
    public boolean generar(int idPais, int año) {
        Pais pais = paisServicio.obtener(idPais);
        festivos = festivoServicio.listar(idPais, año);

        for (FestivoDto festivo : festivos) {
            System.out.println(festivo.getFecha() + " " + festivo.getNombre());
        }

        Tipo tipo1 = repositorioTipo.obtenerPorId(1).get();
        Tipo tipo2 = repositorioTipo.obtenerPorId(2).get();
        Tipo tipo3 = repositorioTipo.obtenerPorId(3).get();

        List<Calendario> fechas = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, año);
        calendar.set(Calendar.DAY_OF_YEAR, 1); // Establecer el primer día del año

        while (calendar.get(Calendar.YEAR) == año) {
            System.out.println("Fecha a procesar "+calendar.getTime());
            Calendario calendario = new Calendario();
            LocalDate fecha = calendar.getTime().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            calendario.setFecha(fecha);
            if (esFestivo(calendario.getFecha()))
                calendario.setTipo(tipo3);
            else if (esFinSemana(obtenerDiaSemana(calendario.getFecha())))
                calendario.setTipo(tipo2);
            else
                calendario.setTipo(tipo1);

            calendario.setDescripcion(obtenerDiaSemana(calendario.getFecha()));
            calendario.setPais(pais);
            fechas.add(calendario);
            calendar.add(Calendar.DAY_OF_YEAR, 1); // Avanzar al siguiente día
        }

        for (Calendario calendario : fechas) {
            System.out.println(
                    calendario.getFecha() + " " + calendario.getTipo().getTipo() + " " + calendario.getDescripcion());

            Calendario encontrado = repositorio.obtener(idPais, calendario.getFecha());
            if (encontrado != null) {
                calendario.setId(encontrado.getId());
            } else {
                calendario.setId(0);

            }
            repositorio.guardar(calendario);
        }
        return true;
    }

    @Override
    public List<Calendario> listar(int idPais, int año) {
        return repositorio.listarPorAño(idPais, año);
    }

}
