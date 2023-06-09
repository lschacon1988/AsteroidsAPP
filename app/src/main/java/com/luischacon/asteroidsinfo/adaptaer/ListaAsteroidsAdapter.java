package com.luischacon.asteroidsinfo.adaptaer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.luischacon.asteroidsinfo.R;
import com.luischacon.asteroidsinfo.db.entities.Asteroit;
import com.luischacon.asteroidsinfo.db.entities.NearEarthObject;

import java.util.ArrayList;

public class ListaAsteroidsAdapter
        extends RecyclerView.Adapter<ListaAsteroidsAdapter.AsteroidsViewHolders>
        implements View.OnClickListener {

    ArrayList<Asteroit> listAsteroids;


    public ListaAsteroidsAdapter(ArrayList<Asteroit> listAsteroids) {
        this.listAsteroids = listAsteroids;
    }

    @NonNull
    @Override
    public ListaAsteroidsAdapter.AsteroidsViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((parent.getContext())).inflate(R.layout.lista_items_asteroids,null,false);
        return new AsteroidsViewHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaAsteroidsAdapter.AsteroidsViewHolders holder, int position) {

        holder.getTxt_item_name().setText("Nombre:\n"+listAsteroids.get(position).getName());
        holder.getTxt_item_magnitude().setText("Magnitud:\n"+listAsteroids.get(position).getAbsolute_magnitude_h().toString());
        holder.getTxt_item_diameter().setText("Diametro:\n"+listAsteroids.get(position).getEstimated_diameter_m().toString());



    }

    @Override
    public int getItemCount() {
        return listAsteroids.size();
    }

    public void setData(ArrayList<Asteroit> listAsteroids) {
        this.listAsteroids = listAsteroids;
    }

    @Override
    public void onClick(View v) {

    }

    public class AsteroidsViewHolders extends RecyclerView.ViewHolder {
        private TextView txt_item_name,txt_item_magnitude, txt_item_diameter;
        public AsteroidsViewHolders(@NonNull View itemView) {
            super(itemView);

            txt_item_name = (TextView) itemView.findViewById(R.id.txt_item_name);
            txt_item_magnitude = (TextView) itemView.findViewById(R.id.txt_item_magnitude);
            txt_item_diameter = (TextView) itemView.findViewById(R.id.txt_item_diameter);


        }


        public TextView getTxt_item_name() {
            return txt_item_name;
        }

        public TextView getTxt_item_magnitude() {
            return txt_item_magnitude;
        }

        public TextView getTxt_item_diameter() {
            return txt_item_diameter;
        }
    }
}



