package sv.edu.usam.api_bomberos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import sv.edu.usam.api_bomberos.ModelResponse.Incidentes;

public class IncidentesAdapter extends RecyclerView.Adapter<IncidentesAdapter.ViewHolder> {

    List<Incidentes> incidenteList;
    Context context;

    public IncidentesAdapter(Context context, List<Incidentes> incidenteList) {
        this.context = context;
        this.incidenteList = incidenteList;
    }

    @NonNull
    @Override
    public IncidentesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.incidentes_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IncidentesAdapter.ViewHolder holder, int position) {
        holder.txvItipo.setText(incidenteList.get(position).getTipo());
        holder.txvIdescripcion.setText(incidenteList.get(position).getDescripcion());
        holder.txvIdireccion.setText(incidenteList.get(position).getDireccion());
        holder.txvIgravedad.setText(incidenteList.get(position).getGravedad());
        holder.txvIfecha_hora.setText(incidenteList.get(position).getFecha_hora());
        holder.txvIpersonas_lesionadas.setText(incidenteList.get(position).getPersonas_lesionadas());
        holder.txvIcosto_danios.setText(incidenteList.get(position).getCosto_danios());
    }

    @Override
    public int getItemCount() {
        return incidenteList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txvItipo , txvIdescripcion , txvIdireccion , txvIgravedad;
        TextView txvIfecha_hora , txvIpersonas_lesionadas , txvIcosto_danios;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txvItipo = itemView.findViewById(R.id.tvItipo);
            txvIdescripcion = itemView.findViewById(R.id.tvIdescripcion);
            txvIdireccion = itemView.findViewById(R.id.tvIdireccion);
            txvIgravedad = itemView.findViewById(R.id.tvIgravedad);
            txvIfecha_hora = itemView.findViewById(R.id.tvIfecha_hora);
            txvIpersonas_lesionadas = itemView.findViewById(R.id.tvIpersonas_lesionadas);
            txvIcosto_danios = itemView.findViewById(R.id.tvIcosto_danios);

        }
    }
}