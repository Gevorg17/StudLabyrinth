package com.shalo.studentlabyrunth.converters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Converter <T> {

    public ArrayList <T> run(String sql_str) {
        int index = 0;
        ArrayList<T> objects = new ArrayList<>();

        sql_str =sql_str.replace("\n","");
        while ((index = sql_str.indexOf(';')) != -1) {
            String sql_obj = sql_str.substring(0,index + 1);

            String[] props = getProps(sql_obj);
            T obj = convert(props);
            objects.add(obj);

            sql_str = sql_str.substring(index + 1, sql_str.length());
        }

        return objects;
    }

    public abstract T convert(String[] props);

    public static String[] getProps(String sql_obj) {
        int index1 = sql_obj.lastIndexOf('(');
        int index2 = sql_obj.lastIndexOf(')');
        String props_str = sql_obj.substring(index1 + 1,index2);
        String [] props = props_str.split(",");

        for (int i = 0; i < props.length; i ++) {
            index1 = props[i].indexOf("'");
            index2 = props[i].lastIndexOf("'");
            if (index1 != -1 && index2 != - 1) props[i] = props[i].substring(index1 + 1, index2);
        }

        return props;
    }

}
