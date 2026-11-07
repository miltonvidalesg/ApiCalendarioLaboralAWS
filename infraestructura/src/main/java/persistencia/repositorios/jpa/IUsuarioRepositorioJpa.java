package calendariolaboral.api.infraestructura.persistencia.repositorios.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import calendariolaboral.api.infraestructura.persistencia.entidades.*;

@Repository
public interface IUsuarioRepositorioJpa extends JpaRepository<UsuarioEntidad, Integer>{

    @Query("SELECT u FROM UsuarioEntidad u  WHERE u.nombre LIKE '%' || ?1 || '%'")
    List<UsuarioEntidad> buscar(String nombre);

    @Query("SELECT u FROM UsuarioEntidad u  WHERE u.usuario = ?1")
    UsuarioEntidad obtener(String usuario);

    @Query("SELECT u FROM UsuarioEntidad u WHERE u.usuario=?1 AND u.clave=?2")
    UsuarioEntidad login(String usuario, String clave);

}
