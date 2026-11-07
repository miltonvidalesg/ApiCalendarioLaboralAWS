package calendariolaboral.api.dominio.entidades;

public class TipoFestivo {

    private int id;
    private String tipo;

    public TipoFestivo(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public TipoFestivo() {
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
