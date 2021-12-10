package sv.edu.usam.api_bomberos.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sv.edu.usam.api_bomberos.Entidades.Incidente;
import sv.edu.usam.api_bomberos.R;

public class AdapterIncidentes extends RecyclerView.Adapter<AdapterIncidentes.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<Incidente> model;

    public AdapterIncidentes(Context context, ArrayList<Incidente> model) {
        this.inflater = LayoutInflater.from(context);
        this.model = model;
    }
    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_incidentes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterIncidentes.ViewHolder holder, int position) {
        String tipo = model.get(position).getTipo();

        holder.tipo.setText(tipo);
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tipo;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tipo = itemView.findViewById(R.id.tipo_incidente);

        }

    }
}
