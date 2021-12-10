package sv.edu.usam.api_bomberos.models;

import java.util.ArrayList;

public class IncidentesRespuesta {
    private ArrayList<Incidentes> results;

    public ArrayList<Incidentes> getResults() {
        return results;
    }

    public void setResults(ArrayList<Incidentes> results) {
        this.results = results;
    }
}
