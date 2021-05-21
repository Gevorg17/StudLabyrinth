package com.shalo.studlabyrinth.models.model;

import android.content.res.AssetManager;

import java.io.*;
import java.util.ArrayList;

public class DBbringer {

    public static String getPoints() throws IOException {
        return read("./files/points.txt");
    }
    public static String getWays() throws IOException {
        return read("./files/ways.txt");
    }
    public static String getMaps() throws IOException {
        return read("./files/maps.txt");
    }
    public static String getPointLinks() throws IOException {
        return read("./files/point_links.txt");
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
