package com.luischacon.asteroidsinfo.adaptaer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.luischacon.asteroidsinfo.R;
import com.luischacon.asteroidsinfo.db.entities.NearEarthObject;

import java.util.ArrayList;

public class ListaAsteroidsAdapter extends RecyclerView.Adapter<ListaAsteroidsAdapter.AsteroidsViewHolders> {

    ArrayList<NearEarthObject> listAsteroids;


    public ListaAsteroidsAdapter(ArrayList<NearEarthObject> listAsteroids) {
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
        System.out.println("POSICION ES "+ listAsteroids.get(position+1).getName().toString());
        holder.getTxt_item_name().setText(listAsteroids.get(position+1).getName().toString());
        holder.getTxt_item_magnitude().setText((int) listAsteroids.get(position+1).getAbsoluteMagnitudeH());

    }

    @Override
    public int getItemCount() {
        return listAsteroids.size();
    }

    public void setData(ArrayList<NearEarthObject> listAsteroids) {
        this.listAsteroids = listAsteroids;
    }

    public class AsteroidsViewHolders extends RecyclerView.ViewHolder {
        private final TextView txt_item_name,txt_item_magnitude;
        public AsteroidsViewHolders(@NonNull View itemView) {
            super(itemView);

            txt_item_name = (TextView) itemView.findViewById(R.id.txt_item_name);
            txt_item_magnitude = (TextView) itemView.findViewById(R.id.txt_item_magnitude);

        }


        public TextView getTxt_item_name() {
            return txt_item_name;
        }

        public TextView getTxt_item_magnitude() {
            return txt_item_magnitude;
        }
    }
}


//public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
//
//    private String[] localDataSet;
//
//    /**
//     * Provide a reference to the type of views that you are using
//     * (custom ViewHolder).
//     */
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        private final TextView textView;
//
//        public ViewHolder(View view) {
//            super(view);
//            // Define click listener for the ViewHolder's View
//
//            textView = (TextView) view.findViewById(R.id.textView);
//        }
//
//        public TextView getTextView() {
//            return textView;
//        }
//    }
//
//
//    public CustomAdapter(String[] dataSet) {
//        localDataSet = dataSet;
//    }
//
//    // Create new views (invoked by the layout manager)
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
//        // Create a new view, which defines the UI of the list item
//        View view = LayoutInflater.from(viewGroup.getContext())
//                .inflate(R.layout.text_row_item, viewGroup, false);
//
//        return new ViewHolder(view);
//    }
//
//    // Replace the contents of a view (invoked by the layout manager)
//    @Override
//    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
//
//        // Get element from your dataset at this position and replace the
//        // contents of the view with that element
//        viewHolder.getTextView().setText(localDataSet[position]);
//    }
//
//    // Return the size of your dataset (invoked by the layout manager)
//    @Override
//    public int getItemCount() {
//        return localDataSet.length;
//    }
//}

