package calendariolaboral.api.infraestructura.persistencia.repositorios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import calendariolaboral.api.dominio.entidades.Pais;
import calendariolaboral.api.core.repositorios.IPaisRepositorio;
import calendariolaboral.api.infraestructura.persistencia.entidades.PaisEntidad;
import calendariolaboral.api.infraestructura.persistencia.mapeadores.PaisMapeador;
import calendariolaboral.api.infraestructura.persistencia.repositorios.jpa.IPaisRepositorioJpa;

@Component
public class PaisRepositorio implements IPaisRepositorio {

    @Autowired
    private IPaisRepositorioJpa repositorio;

    @Override
    public List<Pais> listar() {
        return repositorio.findAll()
                .stream()
                .map(PaisMapeador::toModelo)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Pais> obtenerPorId(int id) {
        return repositorio.findById(id)
                .map(PaisMapeador::toModelo);
    }

    @Override
    public List<Pais> buscarPorNombre(String nombre) {
        return repositorio.buscar(nombre)
                .stream()
                .map(PaisMapeador::toModelo)
                .collect(Collectors.toList());
    }

    @Override
    public Pais guardar(Pais festivo) {
        PaisEntidad festivoEntidad = PaisMapeador.toEntidad(festivo);
        PaisEntidad guardado = repositorio.save(festivoEntidad);
        return PaisMapeador.toModelo(guardado);
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
