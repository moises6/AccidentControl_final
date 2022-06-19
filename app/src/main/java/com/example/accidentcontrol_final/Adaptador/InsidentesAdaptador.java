package com.example.accidentcontrol_final.Adaptador;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.accidentcontrol_final.Modelo.Insidentes;
import com.example.accidentcontrol_final.R;
import  com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.example.accidentcontrol_final.Modelo.Insidentes;

public class InsidentesAdaptador extends  FirestoreRecyclerAdapter<Insidentes, InsidentesAdaptador.ViewHolder> {


    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public InsidentesAdaptador(@NonNull FirestoreRecyclerOptions<Insidentes> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Insidentes model) {
        holder.tipoInsidente.setText(Insidentes.getTipoInsidente());
        holder.descripcion.setText(Insidentes.getDescripcion());
        holder.fecha.setText(Insidentes.getFecha());

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from( parent.getContext()).inflate(R.layout.vista_insidentes, parent, false );
       return  new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tipoInsidente, descripcion, fecha;
        public ViewHolder(@NonNull View itemView){
            super (itemView);

            tipoInsidente = itemView.findViewById(R.id.TipoInsidente);
            descripcion = itemView.findViewById(R.id.Descripcion);
            fecha = itemView.findViewById(R.id.Fecha);



        }
    }
}
