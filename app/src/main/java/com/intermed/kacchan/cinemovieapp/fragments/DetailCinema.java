package com.intermed.kacchan.cinemovieapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.intermed.kacchan.cinemovieapp.R;
import com.squareup.picasso.Picasso;

public class DetailCinema extends Fragment {

    private TextView txtJudul;
    private TextView txtDeskripsi;
    private ImageView imgMovie;
    private TextView txtVote;
    public TextView txtTahun;


    final FragmentActivity c = getActivity();

    public DetailCinema() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_cinema, container, false);
        txtJudul = (TextView) view.findViewById(R.id.txtJudul);
        txtDeskripsi = (TextView) view.findViewById(R.id.txtDeskripsi);
        imgMovie = (ImageView) view.findViewById(R.id.imgMovie);
        txtTahun = (TextView) view.findViewById(R.id.txtTahun);
        imgMovie.setScaleType(ImageView.ScaleType.CENTER_CROP);
        txtVote = (TextView) view.findViewById(R.id.txtVote);
        setHasOptionsMenu(true);
        setRetainInstance(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.detail, menu);
        MenuItem SharedContent = menu.findItem(R.id.mnShared);
        SharedContent.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "[Cinemovie] \nMovie name : " + txtJudul.getText().toString() + "\n\n" +
                        txtDeskripsi.getText().toString() + "\n\n" +
                        "\u2605" + txtVote.getText().toString() + "\n" +
                        txtTahun.getText().toString() + "\n";

                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Cinemovie");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share in your friends"));
                return true;
            }
        });
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Image
        String latar = getActivity().getIntent().getStringExtra("latar");

        String jud = getActivity().getIntent().getStringExtra("judul");
        String des = getActivity().getIntent().getStringExtra("deskripsi");
        String thn = getActivity().getIntent().getStringExtra("tahun");
        String vote = getActivity().getIntent().getStringExtra("vote");

        Picasso.with(getContext()).load(latar).placeholder(R.drawable.logo_item).into(imgMovie);
        txtJudul.setText(jud);
        txtDeskripsi.setText(des);
        txtTahun.setText("Release date : " + thn);
        txtVote.setText("Rating : " + vote + " / 10");

    }



}
