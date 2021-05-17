package com.shalo.studentlabyrunth.converters;

import java.util.ArrayList;

public class ConverterMachine<T> {

    private  Converter converter;

    public ArrayList<T> convert(String sql_str, String status) {
        switch (status) {
            case "point" : converter = new PointConverter();
                break;
            case  "way": converter = new WayConverter();
                break;
            case "map": converter = new MapConverter();
                break;
            case "point_link": converter = new PointLinkConverter();
                break;
        }

        return converter.run(sql_str);
    }
}
