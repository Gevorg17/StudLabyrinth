package com.shalo.studlabyrinth.models.model;


import com.shalo.studlabyrinth.models.Way;

public class WayConverter extends Converter<Way> {
    @Override
    public Way convert(String[] props) {
        int id = Integer.parseInt(props[0]);
        String beginning_point_name = props[1];
        String end_point_name = props[2];
        int map_id = Integer.parseInt(props[3]);

        return new Way(id,beginning_point_name,end_point_name,map_id);
    }
}
