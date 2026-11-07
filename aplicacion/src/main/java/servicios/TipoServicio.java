package calendariolaboral.api.aplicacion.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import calendariolaboral.api.core.servicios.ITipoServicio;
import calendariolaboral.api.core.repositorios.ITipoRepositorio;
import calendariolaboral.api.dominio.entidades.Tipo;

@Service
public class TipoServicio implements ITipoServicio {

    @Autowired
    private ITipoRepositorio repositorio;


    @Override
    public List<Tipo> listar() {
        return repositorio.listar();
    }

    @Override
    public Tipo obtener(int id) {
        return repositorio.obtenerPorId(id).orElse(null);
    }

    @Override
    public List<Tipo> buscar(String nombre) {
        return repositorio.buscarPorNombre(nombre);
    }

    @Override
    public Tipo agregar(Tipo tipo) {
        tipo.setId(0);
        return repositorio.guardar(tipo);
    }

    @Override
    public Tipo modificar(Tipo tipo) {
        var tipoEncontrado = repositorio.obtenerPorId(tipo.getId());
        return tipoEncontrado.isEmpty() ? null : repositorio.guardar(tipo);
    }

    @Override
    public boolean eliminar(int id) {
        return repositorio.eliminar(id);
    }
}
