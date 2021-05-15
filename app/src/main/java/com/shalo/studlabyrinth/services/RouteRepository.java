package com.shalo.studlabyrinth.services;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.shalo.studlabyrinth.models.Route;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class RouteRepository {

    private SQLiteDatabase database;

    public RouteRepository(Context context) {
        database = context.openOrCreateDatabase("appDb",
                MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS routes (id INTEGER primary key, mapName TEXT, beginningPointName TEXT, endPointName TEXT);");
    }

    public List<Route> Select(){
        Cursor cursor = database.rawQuery("SELECT * FROM routes;", null);;

        List<Route> routes = new ArrayList<>();

        while (cursor.moveToNext())
            routes.add(GetRoute(cursor));

        cursor.close();

        return routes;
    }

    public Route Select(int id) {
        Cursor cursor = database.rawQuery("SELECT * FROM routes where id =" + id + ";", null);;

        Route route = null;

        if(cursor.moveToFirst()){
            route = GetRoute(cursor);
        }

        cursor.close();

        return route;
    }

    private Route GetRoute(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndex(DbHelper.KEY_ID));
        String mapName = cursor.getString(cursor.getColumnIndex(DbHelper.KEY_MAP_NAME));
        String beginningPointName = cursor.getString(cursor.getColumnIndex(DbHelper.KEY_BEGINNING_POINT_NAME));
        String endPointName = cursor.getString(cursor.getColumnIndex(DbHelper.KEY_END_POINT_NAME));

        return new Route(id,mapName,beginningPointName,endPointName);
    }

    public void Insert(Route route) {
        String query = String.format("insert into routes (mapName,beginningPointName,endPointName) values ('%s','%s','%s')",
                route.getMapName(),route.getBeginningPointName(),route.getEndPointName());
        database.execSQL(query);
        System.out.println("Repo");
        System.out.println(Select().size());
    }

    public void Delete(int id) {
        database.delete(DbHelper.TABLE_NAME, DbHelper.KEY_ID +" = ?",
                new String[]{String.valueOf(id)});
    }

    public void DeleteAll(){
        database.delete(DbHelper.TABLE_NAME,null,null);
    }
}
