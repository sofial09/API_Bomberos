package sv.edu.usam.api_bomberos;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientIncidente {
    private static final String BASE_URL = "https://apibomberos.000webhostapp.com/datos/incidentes.php?accion=listar";
    private static Retrofit retrofit = null;

    public static ApiInterface RetrofitClientIncidente(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiInterface.class);
    }
}
