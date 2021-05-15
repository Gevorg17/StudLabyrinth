package com.shalo.studlabyrinth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CorpusMapsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapspage);
    }

    public void onClickMain2(View view) {
        Intent intent = new Intent(CorpusMapsActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickHistory(View view) {
        Intent intent = new Intent(CorpusMapsActivity.this, HistoryActivity.class);
        startActivity(intent);
    }
}