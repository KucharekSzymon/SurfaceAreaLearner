package com.example.surface_area_learner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class Triangle extends View
{
    Paint paint = null;
    public Triangle(Context context)
    {
        super(context);
        paint = new Paint();
    }
    public void drawTriangle(Canvas canvas, Paint paint, int a, int b, int width) {
        int halfWidth = width / 2;
        int x = getWidth();
        int y = getHeight();

        Path path = new Path();
        path.moveTo(a, b - halfWidth); // Top
        path.lineTo(a - halfWidth, b + halfWidth); // Bottom left
        path.lineTo(a + halfWidth, b + halfWidth); // Bottom right
        path.lineTo(a, b - halfWidth); // Back to Top
        path.close();

        canvas.drawPath(path, paint);

        paint.setColor(Color.BLACK);
        canvas.drawText("a",x/2-halfWidth,b,paint);
        canvas.drawText("A = (√3/ 4 )*a", x/2-50, 35, paint);
        canvas.drawText("L = 3a", x/2-50, 65, paint);
    }
    public void drawSecond(Canvas canvas, Paint paint,int a, int b) {
        int x = getWidth();
        int y = getHeight();

        Path path = new Path();
        path.moveTo(x/2-b/2,410);
        path.lineTo(x/2-b/2,410+a);
        path.lineTo(x/2-b/2+b,410+a);
        path.moveTo(x/2-b/2,410);
        path.close();

        canvas.drawPath(path, paint);

        paint.setColor(Color.BLACK);
        canvas.drawText("a",x/2-b/2-30,400+a/2,paint);
        canvas.drawText("b",x/2,440+a,paint);

        canvas.drawText("A = (a*b)/2", x/2-50, 375, paint);
        canvas.drawText("L = a+b+√(a^2+b^2)", x/2-50, 405, paint);
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
        drawTriangle(canvas, paint, x/2, 200, 200);
        paint.setColor(Color.GRAY);
        drawSecond(canvas,paint,200,320);


    }
}