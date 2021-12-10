package sv.edu.usam.api_bomberos.ModelResponse;

public class Incidentes {
    String tipo;
    String descripcion;
    String direccion;
    String gravedad;
    String fecha_hora;
    String personas_lesionadas;
    String costo_danios;

    public Incidentes(String tipo, String descripcion, String direccion, String gravedad, String fecha_hora, String personas_lesionadas, String costo_danios) {
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

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getPersonas_lesionadas() {
        return personas_lesionadas;
    }

    public void setPersonas_lesionadas(String personas_lesionadas) {
        this.personas_lesionadas = personas_lesionadas;
    }

    public String getCosto_danios() {
        return costo_danios;
    }

    public void setCosto_danios(String costo_danios) {
        this.costo_danios = costo_danios;
    }
}