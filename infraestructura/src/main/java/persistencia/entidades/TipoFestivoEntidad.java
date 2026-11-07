package calendariolaboral.api.infraestructura.persistencia.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipofestivo")
public class TipoFestivoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_tipofestivo")
    @SequenceGenerator(name = "secuencia_tipofestivo", sequenceName = "secuencia_tipofestivo", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Column(name = "tipo", length = 100, unique = true)
    private String tipo;

    public TipoFestivoEntidad(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public TipoFestivoEntidad() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
