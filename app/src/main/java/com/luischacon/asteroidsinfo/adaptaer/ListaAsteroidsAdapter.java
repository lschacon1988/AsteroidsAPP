package com.luischacon.asteroidsinfo.adaptaer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.luischacon.asteroidsinfo.R;
import com.luischacon.asteroidsinfo.db.entities.Asteroid;

import java.util.ArrayList;

public class ListaAsteroidsAdapter extends RecyclerView.Adapter<ListaAsteroidsAdapter.AsteroidsViewHolders> {

    ArrayList<Asteroid> listAsteroids;


    public ListaAsteroidsAdapter(ArrayList<Asteroid> listAsteroids) {
        this.listAsteroids = listAsteroids;
    }

    @NonNull
    @Override
    public ListaAsteroidsAdapter.AsteroidsViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((parent.getContext())).inflate(R.layout.lista_item_asteroids,null,false);
        return new AsteroidsViewHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaAsteroidsAdapter.AsteroidsViewHolders holder, int position) {
        holder.txt_item_name.setText(listAsteroids.get(position).getName());
//        holder.txt_item_diameter.setText((int) listAsteroids.get(position).getEstimatedDiameterMeters());
//        holder.txt_item_magnitude.setText((int) listAsteroids.get(position).getAbsoluteMagnitudeH());

    }

    @Override
    public int getItemCount() {
        return listAsteroids.size();
    }

    public void setData(ArrayList<Asteroid> listAsteroids) {
    }

    public class AsteroidsViewHolders extends RecyclerView.ViewHolder {

        TextView txt_item_name, txt_item_diameter,txt_item_magnitude;
        public AsteroidsViewHolders(@NonNull View itemView) {

            super(itemView);

            txt_item_name = txt_item_name.findViewById(R.id.txt_item_name);
            txt_item_diameter = txt_item_diameter.findViewById(R.id.txt_item_diameter);
            txt_item_magnitude = txt_item_magnitude.findViewById(R.id.txt_item_magnitude);

        }
    }
}
