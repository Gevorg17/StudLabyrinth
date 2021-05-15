package com.shalo.studlabyrinth.services;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABAE_NAME = "appDb";
    public static final String TABLE_NAME = "routes";

    public static final String KEY_ID = "id";
    public static final String KEY_MAP_NAME = "mapName";
    public static final String KEY_BEGINNING_POINT_NAME = "beginningPointName";
    public static final String KEY_END_POINT_NAME = "endPointName";

    public DbHelper(@Nullable Context context) {
        super(context, DATABAE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = String.format("" +
                "create table %s " +
                "(" +
                    "%s integer primary key," +
                    "%s text " +
                    "%s text" +
                    "%s text  " +
                ")", TABLE_NAME,KEY_ID,KEY_MAP_NAME,KEY_BEGINNING_POINT_NAME,KEY_END_POINT_NAME);
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "drop table if exists " + TABLE_NAME;
        db.execSQL(query);

        onCreate(db);
    }
}
