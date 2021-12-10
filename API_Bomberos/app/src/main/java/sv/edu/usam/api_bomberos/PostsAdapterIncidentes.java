package sv.edu.usam.api_bomberos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostsAdapterIncidentes extends RecyclerView.Adapter<PostsAdapterIncidentes.ViewHolder> {

    private final List<PostsIncidentes> postsIncidentes;

    public PostsAdapterIncidentes(List<PostsIncidentes> postsIncidentes) {
        this.postsIncidentes = postsIncidentes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_incidentes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapterIncidentes.ViewHolder holder, int position) {
        holder.tvItipo.setText(postsIncidentes.get(position).getTipo());
        holder.tvIdescripcion.setText(postsIncidentes.get(position).getDescripcion());
        holder.tvIdireccion.setText(postsIncidentes.get(position).getDireccion());
        holder.tvIgravedad.setText(postsIncidentes.get(position).getGravedad());
        holder.tvIfechahora.setText(postsIncidentes.get(position).getFecha_hora());
        holder.tvIpersonaslesionadas.setText(postsIncidentes.get(position).getPersonas_lesionadas());
        holder.tvIcosto.setText(postsIncidentes.get(position).getCosto_danios());
    }

    @Override
    public int getItemCount() {
        return postsIncidentes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

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
