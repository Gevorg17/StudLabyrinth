package com.shalo.studlabyrinth;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.shalo.studlabyrinth.models.CustomImageView;
import com.shalo.studlabyrinth.models.Point;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CorpsMapsActivity extends AppCompatActivity {

    private List<Point> points;
    private String firstMapName;
    private String secondMapName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapspage);

        Bundle arguments = getIntent().getExtras();
//        points = (List<Point>) (Parcelable) arguments.get("points");
        firstMapName = (String) arguments.get("firstMap");
        firstMapName = firstMapName.replaceAll(" ","");

        CustomImageView image = (CustomImageView) findViewById(R.id.image1);
        CustomImageView image2 = (CustomImageView) findViewById(R.id.image2);

        if (arguments.get("secondMap") != null) {
            secondMapName = (String) arguments.get("secondMap");
            secondMapName = secondMapName.replaceAll(" ","");
        }

        try {
            InputStream inStream = getAssets().open(firstMapName + ".png");
            Drawable drw = Drawable.createFromStream(inStream, null);
            image.setImageDrawable(drw);
            inStream.close();
            if (arguments.get("secondMap") != null) {
                inStream = getAssets().open(secondMapName + ".png");
                drw = Drawable.createFromStream(inStream, null);
                image2.setImageDrawable(drw);
                inStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onClickMain2(View view) {
        Intent intent = new Intent(CorpsMapsActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickHistory(View view) {
        Intent intent = new Intent(CorpsMapsActivity.this, HistoryActivity.class);
        startActivity(intent);
    }

    public void drawWay(ImageView image, List<Point> points) {
    }

}