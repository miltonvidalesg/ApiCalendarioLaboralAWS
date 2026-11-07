package calendariolaboral.api.aplicacion.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import calendariolaboral.api.dominio.entidades.*;
import calendariolaboral.api.core.servicios.*;
import calendariolaboral.api.core.repositorios.*;

@Service
public class PaisServicio implements IPaisServicio {

    @Autowired
    private IPaisRepositorio repositorio;


    @Override
    public List<Pais> listar() {
        return repositorio.listar();
    }

    @Override
    public Pais obtener(int id) {
        return repositorio.obtenerPorId(id).orElse(null);
    }

    @Override
    public List<Pais> buscar(String nombre) {
        return repositorio.buscarPorNombre(nombre);
    }

    @Override
    public Pais agregar(Pais pais) {
        pais.setId(0);
        return repositorio.guardar(pais);
    }

    @Override
    public Pais modificar(Pais pais) {
        var paisEncontrado = repositorio.obtenerPorId(pais.getId());
        return paisEncontrado.isEmpty() ? null : repositorio.guardar(pais);
    }

    public boolean eliminar(int id) {
        return repositorio.eliminar(id);
    }


}
