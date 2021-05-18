package com.shalo.studlabyrinth.models.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.shalo.studlabyrinth.models.Map;
import com.shalo.studlabyrinth.models.Point;
import com.shalo.studlabyrinth.models.Point_link;
import com.shalo.studlabyrinth.models.Route;
import com.shalo.studlabyrinth.models.Way;
import com.shalo.studlabyrinth.models.model.ConverterMachine;
import com.shalo.studlabyrinth.models.model.DBbringer;
import com.shalo.studlabyrinth.services.SearchAlgorithm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AppSearchAlgorithm implements SearchAlgorithm {
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public List<Point> search(Route route) throws IOException {
        ConverterMachine machine = new ConverterMachine();

        ArrayList<Point> points = (ArrayList<Point>) machine.convert(DBbringer.getPoints(),"point");
        ArrayList<Map> maps = (ArrayList<Map>) machine.convert(DBbringer.getMaps(),"map");
        ArrayList<Way> ways = (ArrayList<Way>) machine.convert(DBbringer.getWays(),"way");
        ArrayList<Point_link> point_links = (ArrayList<Point_link>) machine.convert(DBbringer.getPointLinks(),"point_link");


        Map currentMap = maps.stream().filter(map -> map.getName().equals(route.getMapName())).findFirst().get();

        currentMap.setWays(new HashSet<>(ways));

        Way currentWay = currentMap.findWayByTwoPointNames(route.getBeginningPointName(),route.getEndPointName());

        List<Integer> pointIds = point_links.stream().filter(point_link ->
                point_link.getWay_id() == currentWay.getId())
                .sorted(new PointLinkComparator())
                .map(point_link -> point_link.getPoint_id())
                .collect(Collectors.toList());

        List<Point> needPoints = pointIds.stream()
                .map(id -> points.stream()
                        .filter(point -> point.getId() == id).findFirst().get())
                .collect(Collectors.toList());

        return needPoints;
    }

    class PointLinkComparator implements Comparator<Point_link>{

        @Override
        public int compare(Point_link o1, Point_link o2) {
            return String.valueOf(o1.getNumber()).compareTo(String.valueOf(o2.getNumber()));
        }
    }
}
