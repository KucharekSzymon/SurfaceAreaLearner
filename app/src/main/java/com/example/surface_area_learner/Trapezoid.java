package com.example.surface_area_learner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class Trapezoid extends View
{
    Paint paint = null;
    public Trapezoid(Context context)
    {
        super(context);
        paint = new Paint();
    }
    public void drawTrap(Canvas canvas, Paint paint, int a, int b, int h) {
        int x = getWidth();
        int y = getHeight();

        Path path = new Path();
        path.moveTo(x/2-b/2,120); // Top
        path.lineTo(x/2-b/2,120+h);
        path.lineTo(x/2-b/2+b,120+h);
        path.lineTo(x/2-b/2+a,120);
        path.moveTo(x/2-b/2,120); // Top
        path.close();

        canvas.drawPath(path, paint);

        paint.setColor(Color.BLACK);
        canvas.drawText("h",x/2-b/2-30,120+h/2,paint);
        canvas.drawText("a",x/2-b/2+a/2,110,paint);
        canvas.drawText("b",x/2,120+h+30,paint);

        canvas.drawText("A = (a+b/2)h", x/2-b/2, 35, paint);
        canvas.drawText("L = a+b+h+√((b-a)^2h^2)", x/2-b/2, 65, paint);
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
        drawTrap(canvas, paint, 150, 280, 110);



    }
}