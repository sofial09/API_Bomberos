package sv.edu.usam.api_bomberos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/mostrar")
    Call<List<PostsIncidentes>> getPostIncidentes();
}
