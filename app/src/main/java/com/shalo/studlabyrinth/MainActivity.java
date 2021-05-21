package com.shalo.studlabyrinth;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.shalo.studlabyrinth.models.Point;
import com.shalo.studlabyrinth.models.Route;
import com.shalo.studlabyrinth.models.model.AppSearchAlgorithm;
import com.shalo.studlabyrinth.services.RouteRepository;
import com.shalo.studlabyrinth.services.WayFinder;

import java.io.IOException;
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
    public void onClickMaps(View view) throws IOException {
        Route routeToSend = new Route(((Spinner) findViewById(R.id.MapName)).getSelectedItem().toString(),
                                      ((Spinner) findViewById(R.id.BeginningPointName)).getSelectedItem().toString(),
                                      ((Spinner) findViewById(R.id.endPointName)).getSelectedItem().toString());

        WayFinder finder = new WayFinder(new AppSearchAlgorithm());
//        List<Point> points = finder.find(routeToSend);
//
        CheckBox checkBox = findViewById(R.id.location);
//
        Intent intent;
        if (checkBox.isChecked()) {
            intent = new Intent(MainActivity.this, CorpsMapsActivity.class);

            if (routeToSend.getBeginningPointName().charAt(0) != routeToSend.getEndPointName().charAt(0)) {
                //        intent.putExtra("points", (Parcelable) points);
                intent.putExtra("firstMap", routeToSend.getMapName());
                String secondMap = routeToSend.getMapName().replace(routeToSend.getMapName().charAt(5), routeToSend.getEndPointName().charAt(0));
                intent.putExtra("secondMap", secondMap);
            }
            else {
                //        intent.putExtra("points", (Parcelable) points);
                intent.putExtra("firstMap", routeToSend.getMapName());
            }
            //        intent.putExtra("points", (Parcelable) points);
            intent.putExtra("map", routeToSend.getMapName());
        }
        else {
            intent = new Intent(MainActivity.this, MapsActivity.class);
            //        intent.putExtra("points", (Parcelable) points);
        }

        startActivity(intent);
    }

    public void onClickHistory(View view) {
        Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
        startActivity(intent);
    }

    public void locationChanged(View view) {
        Spinner mapName = findViewById(R.id.MapName);
        Spinner beginningPoint = findViewById(R.id.BeginningPointName);
        Spinner endPoint = findViewById(R.id.endPointName);

        CheckBox location = findViewById(R.id.location);

        if (location.isChecked()) {
            ArrayAdapter<?> adapter =
                    ArrayAdapter.createFromResource(this, R.array.mapNameCorps, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            mapName.setAdapter(adapter);

            adapter = ArrayAdapter.createFromResource(this, R.array.beginningPointCorps, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            beginningPoint.setAdapter(adapter);

            adapter = ArrayAdapter.createFromResource(this, R.array.endPointCorps, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            endPoint.setAdapter(adapter);
        } else {
            ArrayAdapter<?> adapter =
                    ArrayAdapter.createFromResource(this, R.array.mapName, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            mapName.setAdapter(adapter);

            adapter = ArrayAdapter.createFromResource(this, R.array.beginningPoint, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            beginningPoint.setAdapter(adapter);

            adapter = ArrayAdapter.createFromResource(this, R.array.endPoint, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            endPoint.setAdapter(adapter);
        }
    }
}