package com.shalo.studlabyrinth.services;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.shalo.studlabyrinth.models.Map;
import com.shalo.studlabyrinth.models.Point;
import com.shalo.studlabyrinth.models.Route;
import com.shalo.studlabyrinth.models.Way;

import java.io.IOException;
import java.util.List;

public class ApiSearchAlgorithm implements SearchAlgorithm {
    private ApiService apiService;

    public ApiSearchAlgorithm() {
        apiService = new ApiService();
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public List<Point> search(Route route) throws IOException {
        Map currentMap = apiService.getMaps().stream().filter(map -> map.getName().equals(route.getMapName())).findFirst().get();

        Way currentWay = currentMap.findWayByTwoPointNames(route.getBeginningPointName(), route.getEndPointName());

        return currentWay.getPoints();
    }
}
