package sv.edu.usam.api_bomberos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import sv.edu.usam.api_bomberos.ModelResponse.Incidentes;
import sv.edu.usam.api_bomberos.ModelResponse.ListaIncidentesResponse;

public class FragmentIncidentes extends Fragment {

    RecyclerView recyclerView;
    List<Incidentes> incidentesList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_incidentes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerIncidentes);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //retrofit

        Call<ListaIncidentesResponse> call = RetrofitClient.getInstance().getApi().listaAllIncidentes();
        call.enqueue(new Callback<ListaIncidentesResponse>() {
            @Override
            public void onResponse(Call<ListaIncidentesResponse> call, Response<ListaIncidentesResponse> response) {
                if (response.isSuccessful()){
                    incidentesList = response.body().getIncidentesList();
                    recyclerView.setAdapter(new IncidentesAdapter(getActivity(), incidentesList));
                }else{
                    Toast.makeText(getActivity(), response.body().getError(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListaIncidentesResponse> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}