package calendariolaboral.api.dominio.entidades;

public class Festivo {

    private int id;
    private String nombre;
    private int dia;
    private int mes;
    private int diasPascua;
    private Pais pais;
    private TipoFestivo tipo;

    public Festivo() {
    }



    public Festivo(int id, String nombre, int dia, int mes, int diasPascua, Pais pais, TipoFestivo tipo) {
        this.id = id;
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.diasPascua = diasPascua;
        this.pais = pais;
        this.tipo = tipo;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDiasPascua() {
        return diasPascua;
    }

    public void setDiasPascua(int diasPascua) {
        this.diasPascua = diasPascua;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }



    public TipoFestivo getTipo() {
        return tipo;
    }



    public void setTipo(TipoFestivo tipo) {
        this.tipo = tipo;
    }



}
