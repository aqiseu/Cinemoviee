package com.intermed.kacchan.cinemovieapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.intermed.kacchan.cinemovieapp.fragments.DetailCinema;

public class DetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment, new DetailCinema())
                    .commit();
        }
    }
}
