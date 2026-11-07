package calendariolaboral.api.infraestructura.persistencia.entidades;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "calendario")
public class CalendarioEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_calendario")
    @SequenceGenerator(name = "secuencia_calendario", sequenceName = "secuencia_calendario", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Column(name = "fecha", unique = true)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "idtipo", referencedColumnName = "id")
    private TipoEntidad tipo;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idpais", referencedColumnName = "id")
    private PaisEntidad pais;

    public CalendarioEntidad() {
    }


    public CalendarioEntidad(int id, LocalDate fecha, TipoEntidad tipo, String descripcion, PaisEntidad pais) {
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PaisEntidad getPais() {
        return pais;
    }

    public void setPais(PaisEntidad pais) {
        this.pais = pais;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoEntidad getTipo() {
        return tipo;
    }

    public void setTipo(TipoEntidad tipo) {
        this.tipo = tipo;
    }

}
