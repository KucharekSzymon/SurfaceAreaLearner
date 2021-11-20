package com.example.lista3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class Test extends AppCompatActivity {
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

    }

    double Pole = 0;
    double Obwod = 0;
    private void drawRect()
    {
        Random random = new Random();
        int randwidth = random.nextInt(11-1)+1;
        int b = random.nextInt(11-1)+1;
        TextView parametrs = (TextView)findViewById(R.id.parametrs);
        Pole = randwidth*b;
        Obwod = (2*randwidth)+(2*b);
        parametrs.setText("a = "+String.valueOf(randwidth)+" b = "+String.valueOf(b));
        LinearLayout shapesview = (LinearLayout) findViewById(R.id.shapesView);
        Paint square = new Paint();
        Path path = new Path();
        square.setColor(Color.GRAY);
        square.setStyle(Paint.Style.FILL);
        Bitmap bg = Bitmap.createBitmap(400,250, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bg);
        path.moveTo(0,0);
        path.lineTo(b*10,0);
        path.lineTo(b*10,randwidth*10);
        path.lineTo(0,randwidth*10);
        path.lineTo(0,0);
        path.close();
        canvas.translate(200,126);
        canvas.drawPath(path,square);
        shapesview.setBackground(new BitmapDrawable(bg));
        square.setColor(Color.BLACK);
        square.setTextSize(15);
        canvas.drawText("b",b*10/2,0,square);
        canvas.drawText("a",-10,randwidth*10/2,square);

    }
    private void handleGame(){
        LinearLayout shapesview = (LinearLayout) findViewById(R.id.shapesView);
        EditText pole = (EditText)findViewById(R.id.poleField);
        EditText obwod = (EditText)findViewById(R.id.obwodField);
        if(Integer.parseInt(pole.getText().toString())==Pole && Integer.parseInt(obwod.getText().toString())==Obwod)
        {
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.winner);
            Bitmap bg = Bitmap.createBitmap(400,250, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bg);
            canvas.scale(0.5f,0.5f);
            canvas.drawBitmap(bmp,200,20,null);
            shapesview.setBackground(new BitmapDrawable(bg));
            Toast.makeText(this, "You Won!",
                    Toast.LENGTH_LONG).show();
            Pole = 0;
            Obwod = 0;
            pole.setText("");
            obwod.setText("");
        }
        else {
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.loser);
            Bitmap bg = Bitmap.createBitmap(400,250, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bg);
            canvas.scale(0.5f,0.5f);
            canvas.drawBitmap(bmp,200,50,null);
            shapesview.setBackground(new BitmapDrawable(bg));
            Toast.makeText(this, "You Lost!",
                    Toast.LENGTH_LONG).show();
            Pole = 0;
            Obwod = 0;
            pole.setText("");
            obwod.setText("");
        }
    }

    private void drawSquare()
    {
        Random random = new Random();
        int randwidth = random.nextInt(11-1)+1;
        TextView parametrs = (TextView)findViewById(R.id.parametrs);
        LinearLayout shapesview = (LinearLayout) findViewById(R.id.shapesView);


        Pole = Math.pow(randwidth,2);
        Obwod = 4*randwidth;
        parametrs.setText("a = "+String.valueOf(randwidth));
        Paint square = new Paint();
        Path path = new Path();
        path.moveTo(0,0);
        path.lineTo(randwidth*10,0);
        path.lineTo(randwidth*10,randwidth*10);
        path.lineTo(0,randwidth*10);
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
        Random random = new Random();
        int randwidth = random.nextInt(11-1)+1;
        TextView parametrs = (TextView)findViewById(R.id.parametrs);
        Pole = Math.pow(randwidth,2);
        Obwod = 2*randwidth;
        parametrs.setText("r = "+String.valueOf(randwidth));
        LinearLayout shapesview = (LinearLayout) findViewById(R.id.shapesView);
        Paint circle = new Paint();
        Paint r = new Paint();
        r.setColor(Color.RED);
        r.setStrokeWidth(3);
        r.setStyle(Paint.Style.STROKE);
        circle.setColor(Color.GRAY);
        circle.setStyle(Paint.Style.FILL);
        Bitmap bg = Bitmap.createBitmap(400,250, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bg);
        canvas.drawCircle(200,125,randwidth*10,circle);
        shapesview.setBackground(new BitmapDrawable(bg));
    }
    private void drawParallelogram(){
        Random random = new Random();
        int randwidth = random.nextInt(11-1)+1;
        TextView parametrs = (TextView)findViewById(R.id.parametrs);
        int b =randwidth*2;
        Pole = randwidth*(b+1);

        Obwod = (2*randwidth)+(2*b);
        parametrs.setText("a = "+String.valueOf(randwidth)+" b = "+String.valueOf(b)+" h="+String.valueOf(b+1));
        LinearLayout shapesview = (LinearLayout) findViewById(R.id.shapesView);
        Path parallelogram = new Path();
        Paint parallel = new Paint();
        Bitmap bg = Bitmap.createBitmap(400,250, Bitmap.Config.ARGB_8888);
        parallel.setColor(Color.GRAY);
        parallel.setStyle(Paint.Style.FILL);
        parallelogram.moveTo(0,0);
        parallelogram.lineTo(randwidth*10,0);
        parallelogram.lineTo(b*10,randwidth*10);
        parallelogram.lineTo(randwidth*10,randwidth*10);
        parallelogram.close();

        Canvas canvas = new Canvas(bg);
        canvas.translate(100,100);
        canvas.drawPath(parallelogram,parallel);


        shapesview.setBackground(new BitmapDrawable(bg));

    }
    private void drawTrapezoid(){
        Random random = new Random();
        int randwidth = random.nextInt(11-1)+1;
        int c = random.nextInt(11-1)+1;
        int b =randwidth*2;
        TextView parametrs = (TextView)findViewById(R.id.parametrs);
        Pole = Math.round(((randwidth+b)/2)*randwidth);
        Obwod = randwidth+b+c+randwidth;
        parametrs.setText("a = "+String.valueOf(randwidth)+" b = "+String.valueOf(b)+" c="+String.valueOf(c)+" d="+String.valueOf(randwidth));
        LinearLayout shapesview = (LinearLayout) findViewById(R.id.shapesView);
        Path trapez = new Path();
        Paint trapezoid = new Paint();
        Bitmap bg = Bitmap.createBitmap(400,250, Bitmap.Config.ARGB_8888);
        trapezoid.setColor(Color.GRAY);
        trapezoid.setStyle(Paint.Style.FILL);
        trapez.moveTo(0, 0);
        trapez.lineTo(randwidth*10, 0);
        trapez.lineTo(b*10, c*10);
        trapez.lineTo(0, c*10);
        trapez.lineTo(0, 0);
        trapez.close();
        Canvas canvas = new Canvas(bg);
        canvas.translate(100,100);
        canvas.drawPath(trapez,trapezoid);
        shapesview.setBackground(new BitmapDrawable(bg));
    }
    public void drawTraingle1(){
        Random random = new Random();
        int randwidth = random.nextInt(11-1)+1;
        LinearLayout shapesview = (LinearLayout) findViewById(R.id.shapesView);
        Paint triangle = new Paint();
        Bitmap bg = Bitmap.createBitmap(400,250, Bitmap.Config.ARGB_8888);
        triangle.setColor(Color.GRAY);
        TextView parametrs = (TextView)findViewById(R.id.parametrs);
        Pole = Math.round((Math.sqrt(3) / 4)*(randwidth*randwidth));
        Obwod = 3*randwidth;
        parametrs.setText("a = "+String.valueOf(randwidth));
        triangle.setStyle(Paint.Style.FILL);
        int width=randwidth*10, x=200,y=125;
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
        Random random = new Random();
        int randwidth = random.nextInt(11-1)+1;
        int b = random.nextInt(11-1)+1;
        int c = random.nextInt(11-1)+1;
        Pole = (randwidth*c)/2;
        Obwod = randwidth+b+c;
        TextView parametrs = (TextView)findViewById(R.id.parametrs);
        LinearLayout shapesview = (LinearLayout) findViewById(R.id.shapesView);
        parametrs.setText("a = "+String.valueOf(randwidth)+" b = "+String.valueOf(b)+" c = "+String.valueOf(c));
        Paint triangle = new Paint();
        Bitmap bg = Bitmap.createBitmap(400,250, Bitmap.Config.ARGB_8888);
        triangle.setColor(Color.GRAY);
        triangle.setStyle(Paint.Style.FILL);
        int width=100, x=200,y=125;
        int half = width/2;
        Path path = new Path();
        path.moveTo(0,0);
        path.lineTo(0,c*10);
        path.lineTo(b*10,c*10);
        path.lineTo(0,0);
        path.close();
        Canvas canvas = new Canvas(bg);
        canvas.translate(200,125);
        canvas.drawPath(path,triangle);
        shapesview.setBackground(new BitmapDrawable(bg));
    }

    private void music(boolean win){
        if(win){
            player = MediaPlayer.create(getApplicationContext(),R.raw.win);
            player.start();
        }
        else{
            player = MediaPlayer.create(getApplicationContext(),R.raw.lose);
            player.start();
        }
    }

    public void ButtonClick(View view)
    {
        String ButtonText = ((Button) view).getText().toString();
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
            case "OK":
                handleGame();
                break;
        }
    }
}