package com.example.lista3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Learning extends AppCompatActivity {
    String Login;
    int Step = 0;
    Integer Points = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Login = getIntent().getExtras().getString("Login");
        SharedPreferences prefs = getSharedPreferences(Login,0);
            Step = prefs.getInt("Step",1);
            Points = prefs.getInt("Points",1);
        Toast.makeText(this,"Witaj "+Login+",S: "+Step+",P: "+Points,Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_learn);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Step +=1;
        SharedPreferences prefs = getSharedPreferences(Login,0);
        SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("Step",Step);
            editor.putInt("Points",Points);
            editor.commit();
    }

    private void drawRect()
    {
        TextView pole= (TextView) findViewById(R.id.pole);
        TextView obwod = (TextView)findViewById(R.id.obwod);
        pole.setText("A=a*b");
        obwod.setText("L=2*(a+b)");
        LinearLayout shapesview = (LinearLayout) findViewById(R.id.shapesView);
        Rect r = new Rect(10, 10, 200, 100);
        Paint square = new Paint();
        square.setColor(Color.GRAY);
        square.setStyle(Paint.Style.FILL);
        Bitmap bg = Bitmap.createBitmap(400,250, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bg);
        canvas.translate(90,90);
        canvas.drawRect(r,square);

        shapesview.setBackground(new BitmapDrawable(bg));
    }
    private void drawSquare()
    {
        TextView pole= (TextView) findViewById(R.id.pole);
        TextView obwod = (TextView)findViewById(R.id.obwod);
        pole.setText("A=a^2");
        obwod.setText("L=4*a");
        LinearLayout shapesview = (LinearLayout) findViewById(R.id.shapesView);
        Paint square = new Paint();
        Path path = new Path();
        path.moveTo(0,0);
        path.lineTo(80,0);
        path.lineTo(80,80);
        path.lineTo(0,80);
        path.close();
        square.setColor(Color.GRAY);
        square.setStyle(Paint.Style.FILL);
        Bitmap bg = Bitmap.createBitmap(400,250, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bg);
        canvas.translate(175,100);
        canvas.drawPath(path,square);
        shapesview.setBackground(new BitmapDrawable(bg));
    }
    private void drawCircle(){
        TextView pole= (TextView) findViewById(R.id.pole);
        TextView obwod = (TextView)findViewById(R.id.obwod);
        pole.setText("A=π⋅r^2");
        obwod.setText("L=2πr");
        LinearLayout shapesview = (LinearLayout) findViewById(R.id.shapesView);
        Paint circle = new Paint();
        Paint r = new Paint();
        r.setColor(Color.RED);
        r.setTextSize(20);
        circle.setStyle(Paint.Style.FILL);
        circle.setColor(Color.GRAY);
        Bitmap bg = Bitmap.createBitmap(400,250, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bg);
        canvas.drawCircle(200,125,75,circle);
        canvas.drawLine(200,125,140,125,r);
        canvas.drawText("r",150,150,r);
        shapesview.setBackground(new BitmapDrawable(bg));
    }
    private void drawParallelogram(){
        TextView pole= (TextView) findViewById(R.id.pole);
        TextView obwod = (TextView)findViewById(R.id.obwod);
        pole.setText("A=a*h");
        obwod.setText("L=2*a+2*b");
        LinearLayout shapesview = (LinearLayout) findViewById(R.id.shapesView);
        Path parallelogram = new Path();
        Paint parallel = new Paint();
        Bitmap bg = Bitmap.createBitmap(400,250, Bitmap.Config.ARGB_8888);
        parallel.setColor(Color.GRAY);
        parallel.setStyle(Paint.Style.FILL);
        parallelogram.moveTo(0,0);
        parallelogram.lineTo(100,0);
        parallelogram.lineTo(200,100);
        parallelogram.lineTo(100,100);
        parallelogram.close();

        Canvas canvas = new Canvas(bg);
        canvas.translate(100,100);
        canvas.drawPath(parallelogram,parallel);


        shapesview.setBackground(new BitmapDrawable(bg));

    }
    private void drawTrapezoid(){
        TextView pole= (TextView) findViewById(R.id.pole);
        TextView obwod = (TextView)findViewById(R.id.obwod);
        obwod.setText("A=a+b+c+d");
        pole.setText("L=((a+b)*h)/2");
        LinearLayout shapesview = (LinearLayout) findViewById(R.id.shapesView);
        Path trapez = new Path();
        Paint trapezoid = new Paint();
        Bitmap bg = Bitmap.createBitmap(400,250, Bitmap.Config.ARGB_8888);
        trapezoid.setColor(Color.GRAY);
        trapezoid.setStyle(Paint.Style.FILL);
        trapez.moveTo(0.0f, 0.0f);
        trapez.lineTo(100.0f, 0.0f);
        trapez.lineTo(200.0f, 100.0f);
        trapez.lineTo(0.0f, 100.0f);
        trapez.lineTo(0.0f, 0.0f);
        trapez.close();
        Canvas canvas = new Canvas(bg);
        canvas.translate(100,100);
        canvas.drawPath(trapez,trapezoid);
        shapesview.setBackground(new BitmapDrawable(bg));
    }
    public void drawTraingle1(){
        TextView pole= (TextView) findViewById(R.id.pole);
        TextView obwod = (TextView)findViewById(R.id.obwod);
        LinearLayout shapesview = (LinearLayout) findViewById(R.id.shapesView);
        obwod.setText("A=3a");
        pole.setText("L=(a^2√3)/4");
        Paint triangle = new Paint();
        Bitmap bg = Bitmap.createBitmap(400,250, Bitmap.Config.ARGB_8888);
        triangle.setColor(Color.GRAY);
        triangle.setStyle(Paint.Style.FILL);
        int width=100, x=200,y=125;
        int half = width/2;
        Path path = new Path();
        path.moveTo(x,y-half);
        path.lineTo(x-half,y+half);
        path.lineTo(x+half,y+half);
        path.lineTo(x,y-half);
        path.close();
        Canvas canvas = new Canvas(bg);

        canvas.drawPath(path,triangle);
        shapesview.setBackground(new BitmapDrawable(bg));
    }
    public void drawTraingle2(){
        TextView pole= (TextView) findViewById(R.id.pole);
        TextView obwod = (TextView)findViewById(R.id.obwod);
        LinearLayout shapesview = (LinearLayout) findViewById(R.id.shapesView);
        obwod.setText("A=a+b+c");
        pole.setText("L=(a*h)/2");
        Paint triangle = new Paint();
        Bitmap bg = Bitmap.createBitmap(400,250, Bitmap.Config.ARGB_8888);
        triangle.setColor(Color.GRAY);
        triangle.setStyle(Paint.Style.FILL);
        int width=100, x=200,y=125;
        int half = width/2;
        Path path = new Path();
        path.moveTo(50,50);
        path.lineTo(50,50);
        path.lineTo(50,200);
        path.lineTo(200,200);
        path.close();
        Canvas canvas = new Canvas(bg);
        canvas.translate(75,0);
        canvas.drawPath(path,triangle);
        shapesview.setBackground(new BitmapDrawable(bg));
    }
    public void ButtonClick(View view)
    {
        String ButtonText;
        ButtonText = ((Button) view).getText().toString();
        switch (ButtonText)
        {
            case "Sq":
                drawSquare();
                break;
            case "Rect":
                drawRect();
                break;
            case "Cir":
                drawCircle();
                break;
            case "Parr":
                drawParallelogram();
                break;
            case "Trap":
                drawTrapezoid();
                break;
            case "T1":
                drawTraingle1();
                break;
            case "T2":
                drawTraingle2();
                break;
        }
    }
}