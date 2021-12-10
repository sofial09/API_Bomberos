package sv.edu.usam.api_bomberos.ModelResponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListaIncidentesResponse {

    //@SerializedName("")
    List<Incidentes> incidentesList;
    String error;

    public ListaIncidentesResponse(List<Incidentes> incidentesList, String error) {
        this.incidentesList = incidentesList;
        this.error = error;
    }

    public List<Incidentes> getIncidentesList() {
        return incidentesList;
    }

    public void setIncidentesList(List<Incidentes> incidentesList) {
        this.incidentesList = incidentesList;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
