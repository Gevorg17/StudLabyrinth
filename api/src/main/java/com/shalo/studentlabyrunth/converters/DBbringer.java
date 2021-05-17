package com.shalo.studentlabyrunth.converters;

import com.shalo.studentlabyrunth.domain.Map;
import com.shalo.studentlabyrunth.domain.Point;
import com.shalo.studentlabyrunth.domain.Point_link;
import com.shalo.studentlabyrunth.domain.Way;

import java.io.*;
import java.util.ArrayList;

public class DBbringer {

    public static String getPoints() throws IOException {
        return read("./src/main/resources/static/database/tables/points.txt");
    }
    public static String getWays() throws IOException {
        return read("./src/main/resources/static/database/tables/ways.txt");
    }
    public static String getMaps() throws IOException {
        return read("./src/main/resources/static/database/tables/maps.txt");
    }
    public static String getPointLinks() throws IOException {
        return read("./src/main/resources/static/database/tables/point_links.txt");
    }

    private static String read(String path) throws IOException {
        int i = 0;
        String str = "";
        String result = "";

        File f = new File(path);
        BufferedReader fin = new BufferedReader(new FileReader(f));
        while((str = fin.readLine()) != null){
            result += str;
        }

        return result;
    }

}
