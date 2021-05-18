package com.shalo.studlabyrinth.models.model;


import com.shalo.studlabyrinth.models.Map;

public class MapConverter extends Converter {
    @Override
    public Object convert(String[] props) {
        int id = Integer.parseInt(props[0]);
        String name = props[1];
        int length = Integer.parseInt(props[2]);
        int width = Integer.parseInt(props[3]);

        return new Map(id,name,length,width);
    }
}
