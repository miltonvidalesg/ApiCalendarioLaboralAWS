package calendariolaboral.api.aplicacion.servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import calendariolaboral.api.core.servicios.*;
import calendariolaboral.api.dominio.entidades.*;
import calendariolaboral.api.dominio.dtos.*;
import calendariolaboral.api.core.repositorios.*;

@Service
public class FestivoServicio implements IFestivoServicio {

    @Autowired
    private IFestivoRepositorio repositorio;

    @Override
    public List<Festivo> listar() {
        return repositorio.listar();
    }

    @Override
    public Festivo obtener(int id) {
        return repositorio.obtenerPorId(id).orElse(null);
    }

    @Override
    public List<Festivo> buscar(String nombre) {
        return repositorio.buscarPorNombre(nombre);
    }

    @Override
    public Festivo agregar(Festivo festivo) {
        festivo.setId(0);
        return repositorio.guardar(festivo);
    }

    @Override
    public Festivo modificar(Festivo festivo) {
        var festivoEncontrado = repositorio.obtenerPorId(festivo.getId());
        return festivoEncontrado.isEmpty() ? null : repositorio.guardar(festivo);
    }

    @Override
    public boolean eliminar(int id) {
        return repositorio.eliminar(id);
    }

    @Override
    public boolean verificar(int idPais, LocalDate fecha) {
        var fechasFestivos = getFechasFestivos(idPais, fecha.getYear());
        return fechasFestivos.stream().anyMatch(f -> f.getFecha().equals(fecha));
    }

    private List<FestivoDto> getFechasFestivos(int idPais, int año) {
        List<FestivoDto> fechasFestivos = new ArrayList();
        var festivos = repositorio.listarPorPais(idPais);
        for (var festivo : festivos) {
            LocalDate fechaFestivo;
            switch (festivo.getTipo().getId()) {
                case 1: // Fijo
                    fechaFestivo = LocalDate.of(año, festivo.getMes(), festivo.getDia());
                    fechasFestivos.add(new FestivoDto(festivo.getNombre(), fechaFestivo));
                    break;

                case 2: // Ley Puente Festivo (según Ley 51 de 1983)
                    fechaFestivo = ServicioFechas.siguienteLunes(LocalDate.of(año, festivo.getMes(), festivo.getDia()));
                    fechasFestivos.add(new FestivoDto(festivo.getNombre(), fechaFestivo));
                    break;
                case 3:
                    fechaFestivo = ServicioFechas.agregarDias(ServicioFechas.getPascua(año), festivo.getDiasPascua());
                    fechasFestivos.add(new FestivoDto(festivo.getNombre(), fechaFestivo));
                    break;
                case 4:
                    fechaFestivo = ServicioFechas.siguienteLunes(
                            ServicioFechas.agregarDias(ServicioFechas.getPascua(año), festivo.getDiasPascua()));
                    fechasFestivos.add(new FestivoDto(festivo.getNombre(), fechaFestivo));
                    break;
            }
        }
        return fechasFestivos;
    }

    @Override
    public List<FestivoDto> listar(int idPais, int año) {
        return getFechasFestivos(idPais, año);
    }

}
