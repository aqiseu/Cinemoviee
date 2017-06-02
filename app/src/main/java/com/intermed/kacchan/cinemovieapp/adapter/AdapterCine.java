package com.intermed.kacchan.cinemovieapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.intermed.kacchan.cinemovieapp.R;
import com.intermed.kacchan.cinemovieapp.data.CinemaData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class AdapterCine extends RecyclerView.Adapter<HolderCine> {

    public List<CinemaData.Results> itemList;
    public Context context;

    public AdapterCine(Context context, List<CinemaData.Results> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public HolderCine onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_cinema, null);
        HolderCine rcv = new HolderCine(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(HolderCine holder, int position) {
        // ItemObject.Results item = itemList.get(position);
        Picasso.with(context).load
                ("https://image.tmdb.org/t/p/w185" + itemList.get(position).poster_path)
                .placeholder(R.drawable.logo_item)
                .into(holder.img);

        holder.original_title.setText(itemList.get(position).original_title);
        holder.overview = itemList.get(position).overview;
        holder.thn = itemList.get(position).release_date;
        holder.backdrop = "https://image.tmdb.org/t/p/w600" + itemList.get(position).backdrop_path;
        holder.vote = itemList.get(position).vote_average;
        holder.id_film  = itemList.get(position).id;
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public void setFilter(List<CinemaData.Results> countryModels) {
        itemList = new ArrayList<>();
        itemList.addAll(countryModels);
        notifyDataSetChanged();
    }

}
