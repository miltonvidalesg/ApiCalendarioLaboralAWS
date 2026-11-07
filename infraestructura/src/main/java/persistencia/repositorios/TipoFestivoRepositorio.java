package calendariolaboral.api.infraestructura.persistencia.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import calendariolaboral.api.dominio.entidades.TipoFestivo;
import calendariolaboral.api.core.repositorios.ITipoFestivoRepositorio;
import calendariolaboral.api.infraestructura.persistencia.entidades.TipoFestivoEntidad;
import calendariolaboral.api.infraestructura.persistencia.mapeadores.TipoFestivoMapeador;
import calendariolaboral.api.infraestructura.persistencia.repositorios.jpa.ITipoFestivoRepositorioJpa;


@Component
public class TipoFestivoRepositorio implements ITipoFestivoRepositorio {

    @Autowired
    private ITipoFestivoRepositorioJpa repositorio;

    @Override
    public List<TipoFestivo> listar() {
        return repositorio.findAll()
                .stream()
                .map(TipoFestivoMapeador::toModelo)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TipoFestivo> obtenerPorId(int id) {
        return repositorio.findById(id)
                .map(TipoFestivoMapeador::toModelo);
    }

    @Override
    public List<TipoFestivo> buscarPorNombre(String nombre) {
        return repositorio.buscar(nombre)
                .stream()
                .map(TipoFestivoMapeador::toModelo)
                .collect(Collectors.toList());
    }

    @Override
    public TipoFestivo guardar(TipoFestivo tipo) {
        TipoFestivoEntidad tipoEntidad = TipoFestivoMapeador.toEntidad(tipo);
        TipoFestivoEntidad guardado = repositorio.save(tipoEntidad);
        return TipoFestivoMapeador.toModelo(guardado);
    }

    @Override
    public boolean eliminar(int id) {
        try {
            if (repositorio.existsById(id)) {
                repositorio.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }

    }

}
