package sv.edu.usam.api_bomberos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


import java.util.ArrayList;

import sv.edu.usam.api_bomberos.models.Incidentes;

public class ListaIncidentesAdapter extends RecyclerView.Adapter<ListaIncidentesAdapter.ViewHolder> {

    private ArrayList<Incidentes> dataset;
    Context ccontext;

    public ListaIncidentesAdapter(Context context) {
        ccontext = context;
        dataset = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListaIncidentesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_incidentes,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Incidentes inc =dataset.get(position);

        holder.tvItipo.setText(inc.getTipo());
        holder.tvIdescripcion.setText(inc.getDescripcion());
        holder.tvIdireccion.setText(inc.getDireccion());
        holder.tvIgravedad.setText(inc.getGravedad());
        holder.tvIfechahora.setText(inc.getFecha_hora());
        holder.tvIpersonaslesionadas.setText(inc.getPersonas_lesionadas());
        holder.tvIcosto.setText(inc.getCosto_danios());

        Glide.with(ccontext.getApplicationContext())
                .load("https://apibomberos.000webhostapp.com/datos/incidentes.php?accion=listar")
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void agregarListaIncidentes(ArrayList<Incidentes> incidentesLista) {
        dataset.addAll(incidentesLista);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvItipo;
        TextView tvIdescripcion;
        TextView tvIdireccion;
        TextView tvIgravedad;
        TextView tvIfechahora;
        TextView tvIpersonaslesionadas;
        TextView tvIcosto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItipo = itemView.findViewById(R.id.tipo_inicidente);
            tvIdescripcion = itemView.findViewById(R.id.descripcion_inicidente);
            tvIdireccion = itemView.findViewById(R.id.direccion_inicidente);
            tvIgravedad = itemView.findViewById(R.id.gravedad_inicidente);
            tvIfechahora = itemView.findViewById(R.id.fecha_hora_inicidente);
            tvIpersonaslesionadas = itemView.findViewById(R.id.personas_lesionadas_inicidente);
            tvIcosto = itemView.findViewById(R.id.costo_danios_inicidente);
        }
    }
}
