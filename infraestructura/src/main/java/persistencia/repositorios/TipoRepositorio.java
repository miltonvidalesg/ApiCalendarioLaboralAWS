package calendariolaboral.api.infraestructura.persistencia.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import calendariolaboral.api.dominio.entidades.Tipo;
import calendariolaboral.api.core.repositorios.ITipoRepositorio;
import calendariolaboral.api.infraestructura.persistencia.entidades.TipoEntidad;
import calendariolaboral.api.infraestructura.persistencia.mapeadores.TipoMapeador;
import calendariolaboral.api.infraestructura.persistencia.repositorios.jpa.ITipoRepositorioJpa;


@Component
public class TipoRepositorio implements ITipoRepositorio {

    @Autowired
    private ITipoRepositorioJpa repositorio;

    @Override
    public List<Tipo> listar() {
        return repositorio.findAll()
                .stream()
                .map(TipoMapeador::toModelo)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Tipo> obtenerPorId(int id) {
        return repositorio.findById(id)
                .map(TipoMapeador::toModelo);
    }

    @Override
    public List<Tipo> buscarPorNombre(String nombre) {
        return repositorio.buscar(nombre)
                .stream()
                .map(TipoMapeador::toModelo)
                .collect(Collectors.toList());
    }

    @Override
    public Tipo guardar(Tipo tipo) {
        TipoEntidad tipoEntidad = TipoMapeador.toEntidad(tipo);
        TipoEntidad guardado = repositorio.save(tipoEntidad);
        return TipoMapeador.toModelo(guardado);
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
