package sv.edu.usam.api_bomberos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sv.edu.usam.api_bomberos.api.api;
import sv.edu.usam.api_bomberos.models.Incidentes;
import sv.edu.usam.api_bomberos.models.IncidentesRespuesta;

public class FragmentIncidentes extends Fragment {

    Retrofit retrofit;
    private static final String TAG="Incid";
    RecyclerView RvrecyclerView;
    ListaIncidentesAdapter listaIncidentesAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentIncidentes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Incidentes.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentIncidentes newInstance(String param1, String param2) {
        FragmentIncidentes fragment = new FragmentIncidentes();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RvrecyclerView = RvrecyclerView.findViewById(R.id.recyclerincidentes);
        listaIncidentesAdapter= new ListaIncidentesAdapter(getContext());
        RvrecyclerView.setAdapter(listaIncidentesAdapter);
        RvrecyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),3);
        RvrecyclerView.setLayoutManager(layoutManager);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://apibomberos.000webhostapp.com/datos/incidentes.php")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obtenerListaIncidentes();





        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
    }

    private void obtenerListaIncidentes() {
        api service = retrofit.create(api.class);
        Call<IncidentesRespuesta> incidentesRespuestaCall =service.obtenerListaIncidentes();
        incidentesRespuestaCall.enqueue(new Callback<IncidentesRespuesta>() {
            @Override
            public void onResponse(Call<IncidentesRespuesta> call, Response<IncidentesRespuesta> response) {
                if(response.isSuccessful())
                {
                    IncidentesRespuesta incidentesRespuesta = response.body();
                    ArrayList<Incidentes> incidentesLista = incidentesRespuesta.getResults();

                    listaIncidentesAdapter.agregarListaIncidentes(incidentesLista);

                }
                else {
                    Log.e(TAG," onResponse :" + response.errorBody());

                }
            }

            @Override
            public void onFailure(Call<IncidentesRespuesta> call, Throwable t) {
                Log.e(TAG," onFailure :"+ t.getMessage());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_incidentes, container, false);
    }
}