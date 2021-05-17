package com.shalo.studlabyrinth.services;

import android.os.AsyncTask;

import com.shalo.studlabyrinth.models.Map;
import com.shalo.studlabyrinth.models.Point;
import com.shalo.studlabyrinth.models.Way;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static final String REST_URL = "http://localhost:8080/api/";

    private static Retrofit apiConnection = new Retrofit.Builder()
                .baseUrl(REST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    private static Api api = apiConnection.create(Api.class);



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

    public List<Way> getWays() throws IOException {
        Call<List<Way>> call = api.getWays();
        Response<List<Way>> response = call.execute();
        List<Way> ways = response.body();

        return ways;
    }

    private class GetWays extends AsyncTask<Void, Void, List<Way>> {

        @Override
        protected List<Way> doInBackground(Void... voids) {
            Call<List<Way>> call = api.getWays();
            try {
                Response<List<Way>> response = call.execute();
                List<Way> ways = response.body();

                return ways;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public ArrayList<Map> getMaps() throws IOException {
        Call<ArrayList<Map>> call = api.getMaps();
        Response<ArrayList<Map>> response = call.execute();
        ArrayList<Map> maps = response.body();

        return maps;

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
