package com.shalo.studlabyrinth.services;

import com.shalo.studlabyrinth.models.Map;
import com.shalo.studlabyrinth.models.Point;
import com.shalo.studlabyrinth.models.Way;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("point")
    Call<ArrayList<Point>> getPoints();

    @GET("way")
    Call<List<Way>> getWays();

    @GET("map")
    Call<ArrayList<Map>> getMaps();
}