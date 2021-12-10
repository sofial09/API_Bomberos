package sv.edu.usam.api_bomberos;

public class PostsIncidentes {
    private String tipo;
    private String descripcion;
    private String direccion;
    private String gravedad;
    private String fecha_hora;
    private String personas_lesionadas;
    private String costo_danios;

    public PostsIncidentes(String tipo, String descripcion, String direccion, String gravedad, String fecha_hora, String personas_lesionadas, String costo_danios) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.gravedad = gravedad;
        this.fecha_hora = fecha_hora;
        this.personas_lesionadas = personas_lesionadas;
        this.costo_danios = costo_danios;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getGravedad() {
        return gravedad;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public String getPersonas_lesionadas() {
        return personas_lesionadas;
    }

    public String getCosto_danios() {
        return costo_danios;
    }
}

