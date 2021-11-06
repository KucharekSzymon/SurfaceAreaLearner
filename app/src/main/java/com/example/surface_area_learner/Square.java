package com.example.surface_area_learner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class Square extends View
{
    Paint paint = null;
    public Square(Context context)
    {
        super(context);
        paint = new Paint();
    }
    public void drawTrap(Canvas canvas, Paint paint, int a) {
        int x = getWidth();
        int y = getHeight();

        Path path = new Path();
        path.moveTo(x/2-a/2,120); // Top
        path.lineTo((x/2-a/2),120+a);
        path.lineTo(x/2+a/2,120+a);
        path.lineTo(x/2+a/2,120);
        path.close();
        canvas.drawPath(path, paint);

        paint.setColor(Color.BLACK);
        canvas.drawText("a",x/2,110,paint);
        canvas.drawText("A = a^2", x/2-a/2, 35, paint);
        canvas.drawText("L = 4a", x/2-a/2, 65, paint);
    }


    @Override
    protected void onDraw(Canvas canvas)
    {
        int x = getWidth();
        int y = getHeight();
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        paint.setTextSize(30);

        paint.setColor(Color.GRAY);
        drawTrap(canvas, paint, 110);



    }
}