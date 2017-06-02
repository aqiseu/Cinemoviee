package com.intermed.kacchan.cinemovieapp.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by aqiseu on 5/13/2017.
 */

public class CinemaData implements Serializable {
    @SerializedName("results")

    public List<Results> results;

    public class Results {
        @SerializedName("poster_path")
        public String poster_path;

        @SerializedName("original_title")
        public String original_title;

        @SerializedName("overview")
        public String overview;

        @SerializedName("release_date")
        public String release_date;

        @SerializedName("backdrop_path")
        public String backdrop_path;

        @SerializedName("vote_average")
        public String vote_average;

        @SerializedName("id")
        public String id;
    }}
