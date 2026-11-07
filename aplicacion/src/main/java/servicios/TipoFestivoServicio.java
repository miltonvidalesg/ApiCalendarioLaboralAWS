package calendariolaboral.api.aplicacion.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import calendariolaboral.api.core.servicios.ITipoFestivoServicio;
import calendariolaboral.api.dominio.entidades.TipoFestivo;
import calendariolaboral.api.core.repositorios.ITipoFestivoRepositorio;

@Service
public class TipoFestivoServicio implements ITipoFestivoServicio {

    private final ITipoFestivoRepositorio repositorio;

    public TipoFestivoServicio(ITipoFestivoRepositorio repositorio) {
        this.repositorio = repositorio;
    }
    @Override
    public List<TipoFestivo> listar() {
        return repositorio.listar();
    }

    @Override
    public TipoFestivo obtener(int id) {
        return repositorio.obtenerPorId(id).orElse(null);
    }

    @Override
    public List<TipoFestivo> buscar(String nombre) {
        return repositorio.buscarPorNombre(nombre);
    }

    @Override
    public TipoFestivo agregar(TipoFestivo tipo) {
        tipo.setId(0);
        return repositorio.guardar(tipo);
    }

    @Override
    public TipoFestivo modificar(TipoFestivo tipo) {
        var tipoEncontrado = repositorio.obtenerPorId(tipo.getId());
        return tipoEncontrado.isEmpty() ? null : repositorio.guardar(tipo);
    }

    @Override
    public boolean eliminar(int id) {
        return repositorio.eliminar(id);
    }
}
