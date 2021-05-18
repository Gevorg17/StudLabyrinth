package com.shalo.studlabyrinth;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.shalo.studlabyrinth.models.Point;

import java.util.List;

public class CorpsMapsActivity extends AppCompatActivity {

    private List<Point> points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapspage);

        Bundle arguments = getIntent().getExtras();
        points = (List<Point>) (Parcelable) arguments.get("points");
    }

    public void onClickMain2(View view) {
        Intent intent = new Intent(CorpsMapsActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickHistory(View view) {
        Intent intent = new Intent(CorpsMapsActivity.this, HistoryActivity.class);
        startActivity(intent);
    }
}