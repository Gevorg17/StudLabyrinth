package com.shalo.studlabyrinth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.shalo.studlabyrinth.services.RouteRepository;

public class HistoryActivity extends AppCompatActivity {

    private RouteRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historypage);

        repository = new RouteRepository(this);

        System.out.println(repository.Select().size());

        ListView routeContainer = findViewById(R.id.history_routes);
        RouteAdapter adapter = new RouteAdapter(this, R.layout.list_item_history,repository.Select());
        routeContainer.setAdapter(adapter);
    }

    public void onClickMain(View view) {
        Intent intent = new Intent(HistoryActivity.this, MainActivity.class);
        startActivity(intent);
    }

}