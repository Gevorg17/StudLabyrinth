package com.shalo.studlabyrinth;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Spinner;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.shalo.studlabyrinth.models.Point;
import com.shalo.studlabyrinth.models.Route;
import com.shalo.studlabyrinth.services.RouteRepository;
import com.shalo.studlabyrinth.services.WayFinder;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RouteRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
        repository = new RouteRepository(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClickMaps(View view) {
        Route routeToSend = new Route(((Spinner) findViewById(R.id.MapName)).getSelectedItem().toString(),
                                      ((Spinner) findViewById(R.id.BeginningPointName)).getSelectedItem().toString(),
                                      ((Spinner) findViewById(R.id.endPointName)).getSelectedItem().toString());

        WayFinder finder = new WayFinder();
        List<Point> points = finder.find(routeToSend);

        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
        intent.putExtra("points", (Parcelable) points);
        startActivity(intent);
    }

    public void onClickHistory(View view) {
        Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
        startActivity(intent);
    }
}