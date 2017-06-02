package com.intermed.kacchan.cinemovieapp.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.intermed.kacchan.cinemovieapp.DetailActivity;
import com.intermed.kacchan.cinemovieapp.R;

/**
 * Created by aqiseu on 5/16/2017.
 */

public class HolderCine extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView original_title;
    public String overview;

    public String backdrop;
    public String thn;
    public ImageView img;
    public String vote;
    public String id_film;

    public HolderCine(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        img = (ImageView) itemView.findViewById(R.id.movieImage);
        original_title = (TextView)itemView.findViewById(R.id.movieName);
        img.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(view.getContext(), DetailActivity.class);
        i.putExtra("judul", original_title.getText().toString());
        i.putExtra("deskripsi", overview);
        i.putExtra("tahun", thn);
        i.putExtra("latar", backdrop);
        i.putExtra("vote", vote);
        i.putExtra("id", id_film);

        view.getContext().startActivity(i);
    }


}
