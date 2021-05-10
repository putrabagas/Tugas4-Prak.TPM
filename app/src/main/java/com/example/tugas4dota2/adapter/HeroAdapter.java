package com.example.tugas4dota2.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tugas4dota2.R;
import com.example.tugas4dota2.activity.DetailHeroActivity;
import com.example.tugas4dota2.model.HeroModel;


import java.util.ArrayList;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder>{
    private ArrayList<HeroModel> listHero;
    private Context context;

    public HeroAdapter(ArrayList<HeroModel> dataList, Context context) {
        this.listHero = dataList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_hero, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String image    = listHero.get(position).getImage();
        String name     = listHero.get(position).getName();
        String role     = listHero.get(position).getRole();
        String lore     = listHero.get(position).getLore();

        Glide.with(holder.itemView.getContext())
                .load(listHero.get(position).getImage())
                .into(holder.image);

        holder.name.setText(name);
        holder.role.setText(role);
        holder.lore.setText(lore);

        holder.btnPreview.setOnClickListener(v -> {
            Intent i = new Intent(context, DetailHeroActivity.class);
            i.putExtra("IMAGE_KEY", image);
            i.putExtra("NAME_KEY", name);
            i.putExtra("ROLE_KEY", role);
            i.putExtra("LORE_KEY", lore);
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return (listHero != null) ? listHero.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView image;
        private final TextView name, role, lore;
        private final Button btnPreview;

        public ViewHolder(View itemView) {
            super(itemView);
            image      = itemView.findViewById(R.id.hero_image);
            name       = itemView.findViewById(R.id.hero_name);
            role       = itemView.findViewById(R.id.hero_role);
            lore       = itemView.findViewById(R.id.hero_lore);
            btnPreview = itemView.findViewById(R.id.btnPreview);
        }
    }
}
