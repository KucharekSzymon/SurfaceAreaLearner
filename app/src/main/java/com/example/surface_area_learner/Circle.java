package com.example.surface_area_learner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Circle extends View
{
    Paint paint = null;
    int r;

    public Circle(Context context, int R)
    {
        super(context);
        paint = new Paint();
        this.r = R;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int x = getWidth();
        int y = getHeight();
        int radius = this.r;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        paint.setColor(Color.GRAY);
        canvas.drawCircle(x / 2, y / 2, radius, paint);
        paint.setTextSize(30);
        paint.setColor(Color.BLACK);
        canvas.drawLine(x/2,y/2,x/2+radius,y/2,paint);
        canvas.drawText("R",x/2+radius/2,y/2-10,paint);
        canvas.drawText("A = πr^2", x/2-50, 35, paint);
        canvas.drawText("L = 2πr", x/2-50, 65, paint);
    }
}