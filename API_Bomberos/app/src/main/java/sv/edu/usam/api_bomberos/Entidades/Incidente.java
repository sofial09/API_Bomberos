package sv.edu.usam.api_bomberos.Entidades;

public class Incidente {
    private String tipo;

    public Incidente(){}

    public Incidente(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
