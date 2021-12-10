package sv.edu.usam.api_bomberos.models;

import java.util.ArrayList;

public class IncidenteRespuesta {
    private ArrayList<Incidente> results;

    public ArrayList<Incidente> getResultados() {
        return results;
    }

    public void setResultados(ArrayList<Incidente> resultados) {
        this.results = resultados;
    }
}
