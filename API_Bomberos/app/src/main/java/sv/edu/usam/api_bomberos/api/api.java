package sv.edu.usam.api_bomberos.api;

import retrofit2.Call;
import retrofit2.http.GET;
import sv.edu.usam.api_bomberos.models.IncidentesRespuesta;

public interface api {
    @GET("incidentes.php?accion=listar")
    Call<IncidentesRespuesta> obtenerListaIncidentes();
}
