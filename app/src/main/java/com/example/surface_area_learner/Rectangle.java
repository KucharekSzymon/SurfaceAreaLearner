package com.example.surface_area_learner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class Rectangle extends View
{
    Paint paint = null;
    int a,b;
    public Rectangle(Context context,int A, int B)
    {
        super(context);
        paint = new Paint();
        this.a = A;
        this.b = B;
    }
    public void drawTrap(Canvas canvas, Paint paint) {
        int x = getWidth();
        int y = getHeight();

        Path path = new Path();
        path.moveTo(x/2-a/2,120); // Top
        path.lineTo((x/2-a/2),120+b);
        path.lineTo(x/2+a/2,120+b);
        path.lineTo(x/2+a/2,120);
        path.close();
        canvas.drawPath(path, paint);

        paint.setColor(Color.BLACK);
        canvas.drawText("a",x/2,110,paint);
        canvas.drawText("b",x/2-a/2-30,120+b/2,paint);
        canvas.drawText("A = a*b", x/2-a/2, 35, paint);
        canvas.drawText("L = 2a+2b", x/2-a/2, 65, paint);
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
        drawTrap(canvas, paint);



    }
}