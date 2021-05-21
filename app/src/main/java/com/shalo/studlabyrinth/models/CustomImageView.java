package com.shalo.studlabyrinth.models;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.util.List;

public class CustomImageView extends androidx.appcompat.widget.AppCompatImageView {

    private Paint mPaint = new Paint();
    private List<Point> points;

    public CustomImageView(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public CustomImageView (Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        mPaint.setColor(Color.RED);
//        for (int i = 0; i < points.size() - 1; i++) {
//            canvas.drawLine( (float) points.get(i).getX(), (float) points.get(i).getY(), (float) points.get(i + 1).getX(), (float) points.get(i + 1).getY(), mPaint);
//        }
//
//        canvas.drawLine(10, 10, 20, 20, mPaint);

    }

}
