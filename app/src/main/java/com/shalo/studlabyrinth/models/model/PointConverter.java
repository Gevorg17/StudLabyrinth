package com.shalo.studlabyrinth.models.model;


import com.shalo.studlabyrinth.models.Point;

public class PointConverter extends Converter<Point> {
    @Override
    public Point convert(String[] props) {
        int id = Integer.parseInt(props[0]);
        String name = props[1];
        String status = props[2];
        int x = Integer.parseInt(props[3]);
        int y = Integer.parseInt(props[4]);

        return new Point(id,name,x,y,status);
    }


}
