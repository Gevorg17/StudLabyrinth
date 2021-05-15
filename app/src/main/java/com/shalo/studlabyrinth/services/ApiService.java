package com.shalo.studlabyrinth.services;

import android.os.AsyncTask;

import com.shalo.studlabyrinth.models.Map;
import com.shalo.studlabyrinth.models.Point;
import com.shalo.studlabyrinth.models.Way;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private final String REST_URL = "http://localhost:8080/api/";
    private Api api;

    public  ApiService(){
        Retrofit apiConnection = new Retrofit.Builder()
                .baseUrl(REST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = apiConnection.create(Api.class);
    }


    public ArrayList<Point> getPoints() {
        try {
            ArrayList<Point> points = new GetPoints().execute().get();
            return points;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    private class GetPoints extends AsyncTask<Void, Void, ArrayList<Point>> {

        @Override
        protected ArrayList<Point> doInBackground(Void... voids) {
            Call<ArrayList<Point>> call = api.getPoints();
            try {
                Response<ArrayList<Point>> response = call.execute();
                ArrayList<Point> points = response.body();

                return points;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public ArrayList<Way> getWays() {
        try {
            ArrayList<Way> ways = new GetWays().execute().get();
            return ways;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    private class GetWays extends AsyncTask<Void, Void, ArrayList<Way>> {

        @Override
        protected ArrayList<Way> doInBackground(Void... voids) {
            Call<ArrayList<Way>> call = api.getWays();
            try {
                Response<ArrayList<Way>> response = call.execute();
                ArrayList<Way> ways = response.body();

                return ways;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public ArrayList<Map> getMaps() {
        try {
            ArrayList<Map> maps = new GetMaps().execute().get();
            return maps;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    private class GetMaps extends AsyncTask<Void, Void, ArrayList<Map>> {

        @Override
        protected ArrayList<Map> doInBackground(Void... voids) {
            Call<ArrayList<Map>> call = api.getMaps();
            try {
                Response<ArrayList<Map>> response = call.execute();
                ArrayList<Map> maps = response.body();

                return maps;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
