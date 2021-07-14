package com.example.regionaldata;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class regionAdapter extends RecyclerView.Adapter<regionAdapter.regionViewHolder> {

    private Context context;
    private List<model> regions;

    public regionAdapter(Context context, List<model> regions) {
        this.context = context;
        this.regions = regions;
    }

    @NonNull
    @NotNull
    @Override
    public regionAdapter.regionViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new regionViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.picture_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull regionAdapter.regionViewHolder holder, int position) {
        model region = regions.get(position);
        Picasso.get().load(region.getFlag()).into(holder.imageView);
        holder.name.setText(region.getName());
        holder.capital.setText(region.getCapital());
        holder.region.setText(region.getRegion());
        holder.subregion.setText(region.getSubregion());
        holder.population.setText(region.getPopulation());

    }

    @Override
    public int getItemCount() {
        return regions.size();
    }

    public void getAllRegions(List<model> regions)
    {
        this.regions=regions;
    }


    public static class regionViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView name;
        public TextView capital;
        public TextView region;
        public TextView subregion;
        public TextView population;

        public regionViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.itempic);
            name = itemView.findViewById(R.id.namex);
            capital = itemView.findViewById(R.id.capitalx);
            region = itemView.findViewById(R.id.regionx);
            subregion = itemView.findViewById(R.id.subregionx);
            population = itemView.findViewById(R.id.popx);
        }
    }
}
