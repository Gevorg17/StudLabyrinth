package com.shalo.studlabyrinth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.shalo.studlabyrinth.models.Route;
import com.shalo.studlabyrinth.services.RouteRepository;

public class MainActivity extends AppCompatActivity {

    private RouteRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
        repository = new RouteRepository(this);
    }

    public void onClickMaps(View view) {
        Route routeToSend = new Route(((Spinner) findViewById(R.id.MapName)).getSelectedItem().toString(),
                                      ((Spinner) findViewById(R.id.BeginningPointName)).getSelectedItem().toString(),
                                      ((Spinner) findViewById(R.id.endPointName)).getSelectedItem().toString());

        repository.Insert(routeToSend);
        System.out.println("Main");
        System.out.println(repository.Select().size());
        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
        startActivity(intent);
    }

    public void onClickHistory(View view) {
        Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
        startActivity(intent);
    }
}