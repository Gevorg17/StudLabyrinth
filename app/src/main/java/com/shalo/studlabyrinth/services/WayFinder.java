package com.shalo.studlabyrinth.services;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.shalo.studlabyrinth.models.Map;
import com.shalo.studlabyrinth.models.Point;
import com.shalo.studlabyrinth.models.Route;
import com.shalo.studlabyrinth.models.Way;

import java.io.IOException;
import java.util.List;

public class WayFinder {
    private SearchAlgorithm algorithm;

    public  WayFinder(SearchAlgorithm algorithm){
        this.algorithm = algorithm;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Point> find(Route route) throws IOException {
        return  algorithm.search(route);
    }
}
