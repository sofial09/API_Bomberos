package sv.edu.usam.api_bomberos;

import retrofit2.Call;
import retrofit2.http.GET;
import sv.edu.usam.api_bomberos.ModelResponse.ListaIncidentesResponse;

public interface Api {

    @GET("incidentes.php?accion=listar")
    Call<ListaIncidentesResponse> listaAllIncidentes();

}
