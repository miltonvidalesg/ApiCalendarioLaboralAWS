package calendariolaboral.api.infraestructura.persistencia.repositorios;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import calendariolaboral.api.infraestructura.persistencia.repositorios.jpa.IFestivoRepositorioJpa;
import calendariolaboral.api.infraestructura.persistencia.mapeadores.FestivoMapeador;
import calendariolaboral.api.dominio.entidades.Festivo;
import calendariolaboral.api.infraestructura.persistencia.entidades.FestivoEntidad;
import calendariolaboral.api.core.repositorios.IFestivoRepositorio;
import org.springframework.stereotype.Component;

@Component
public class FestivoRepositorio implements IFestivoRepositorio {

    @Autowired
    private IFestivoRepositorioJpa repositorio;

    @Override
    public List<Festivo> listar() {
        return repositorio.findAll()
                .stream()
                .map(FestivoMapeador::toModelo)
                .collect(Collectors.toList());
    }

    @Override
    public List<Festivo> listarPorPais(int idPais) {
        return repositorio.listarPorPais(idPais)
                .stream()
                .map(FestivoMapeador::toModelo)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Festivo> obtenerPorId(int id) {
        return repositorio.findById(id)
                .map(FestivoMapeador::toModelo);
    }

    @Override
    public List<Festivo> buscarPorNombre(String nombre) {
        return repositorio.buscar(nombre)
                .stream()
                .map(FestivoMapeador::toModelo)
                .collect(Collectors.toList());
    }

    @Override
    public Festivo guardar(Festivo festivo) {
        FestivoEntidad festivoEntidad = FestivoMapeador.toEntidad(festivo);
        FestivoEntidad guardado = repositorio.save(festivoEntidad);
        return FestivoMapeador.toModelo(guardado);
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
