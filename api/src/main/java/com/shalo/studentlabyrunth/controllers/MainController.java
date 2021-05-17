package com.shalo.studentlabyrunth.controllers;

import com.shalo.studentlabyrunth.converters.Converter;
import com.shalo.studentlabyrunth.converters.ConverterMachine;
import com.shalo.studentlabyrunth.converters.DBbringer;
import com.shalo.studentlabyrunth.domain.Map;
import com.shalo.studentlabyrunth.domain.Point;
import com.shalo.studentlabyrunth.domain.Point_link;
import com.shalo.studentlabyrunth.domain.Way;
import com.shalo.studentlabyrunth.repos.MapRepo;
import com.shalo.studentlabyrunth.repos.PointRepo;
import com.shalo.studentlabyrunth.repos.WayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController()
public class MainController {

    @Autowired
    private MapRepo mapRepo;

    @Autowired
    private WayRepo wayRepo;

    @Autowired
    private PointRepo pointRepo;


    @GetMapping("/api/point")
    public Iterable<Point> getPoints() {
        return pointRepo.findAll();
    }

    @GetMapping("/api/way")
    public Iterable<Way> getWays() {
        return wayRepo.findAll();
    }

    @GetMapping("/api/map")
    public Iterable<Map> getMaps() {
        return mapRepo.findAll();
    }

    @GetMapping("/api/database")
    public void dbInit() throws IOException {
        ConverterMachine machine = new ConverterMachine();

        ArrayList<Point> points = (ArrayList<Point>) machine.convert(DBbringer.getPoints(),"point");
        ArrayList<Map> maps = (ArrayList<Map>) machine.convert(DBbringer.getMaps(),"map");
        ArrayList<Way> ways = (ArrayList<Way>) machine.convert(DBbringer.getWays(),"way");
        ArrayList<Point_link> point_links = (ArrayList<Point_link>) machine.convert(DBbringer.getPointLinks(),"point_link");

        for (Point_link point_link : point_links) {
            Way way = ways.get(point_link.getWay_id() - 1);
            Point point = points.get(point_link.getPoint_id() - 1);
            way.getPoints().add(point);
        }

        for (Way way : ways) {
            Map map = maps.get(way.getMap_id() - 1);
            map.getWays().add(way);
        }

        Map map1 = maps.get(0);
        map1.getWays().add(ways.get(0));
        for (Point point : points) pointRepo.save(point);
        for (Map map : maps) mapRepo.save(map);
    }

}
