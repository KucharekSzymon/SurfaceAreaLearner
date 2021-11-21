package com.example.lista3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
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
    String Login;
    int Step = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Login = getIntent().getExtras().getString("Login");
        SharedPreferences prefs = getSharedPreferences(Login,0);
        Step = prefs.getInt("Step",1);
        //Points = prefs.getInt("Points",1);
        Toast.makeText(this,"Hello "+Login+",Step: "+Step,Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_test);
        if(Step%2==0)show(false);else show(true);
        next();

    }
    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences prefs = getSharedPreferences(Login,0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("Step",Step);
        //editor.putInt("Points",Points);
        editor.commit();
    }

    double Pole = 0;
    double Obwod = 0;

    private void next(){
        if(Step%2==0)show(false);else show(true);
        Toast.makeText(this,"Hello "+Login+",Step: "+Step,Toast.LENGTH_SHORT).show();
        switch (Step){
            case 1:
                drawSquare();
                break;
            case 2:
                drawSquare2();
                break;
            case 3:
                drawRect();
                break;
            case 4:
                drawRect2();
                break;
            case 5:
                drawCircle();
                break;
            case 6:
                drawCircle2();
                break;
            default:
                Step = 0;
                if(Step%2==0)show(false);else show(true);
                drawSquare();
                break;
        }
    }

    private void handleGame(){
        if(Step%2==0)show(false);else show(true);
        EditText pole = (EditText)findViewById(R.id.poleField);
        EditText obwod = (EditText)findViewById(R.id.obwodField);
        Button btnOK = ((Button)findViewById(R.id.button2));

        LinearLayout shapesview = (LinearLayout) findViewById(R.id.shapesView);
        if(!pole.getText().toString().equals("") && !obwod.getText().toString().equals("")){
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
                show(true);
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
                show(false);
            }
        }


    }

    private void drawSquare()
    {if(Step%2==0)show(false);else show(true);
        TextView poleText= (TextView) findViewById(R.id.textPole);
        TextView obwodText = (TextView)findViewById(R.id.textObw);
        poleText.setText("A=a^2");
        obwodText.setText("L=4*a");
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
    private void drawRect()
    {
        if(Step%2==0)show(false);else show(true);
        TextView pole= (TextView) findViewById(R.id.textPole);
        TextView obwod = (TextView)findViewById(R.id.textObw);
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
    private void drawRect2()
    {
        if(Step%2==0)show(false);else show(true);
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


    private void drawSquare2()
    {if(Step%2==0)show(false);else show(true);
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
        if(Step%2==0)show(false);else show(true);
        TextView pole= (TextView) findViewById(R.id.textPole);
        TextView obwod = (TextView)findViewById(R.id.textObw);
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
    private void drawCircle2(){
        if(Step%2==0)show(false);else show(true);
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
        if(Step%2==0)show(false);else show(true);
        String ButtonText = ((Button) view).getText().toString();
        switch (ButtonText)
        {
            case "OK":
                handleGame();
                break;
            case "Next":
                Step++;
                next();
                break;
        }
    }
    private void show(boolean x){
        TextView poleText= (TextView) findViewById(R.id.textPole);
        TextView obwodText = (TextView)findViewById(R.id.textObw);
        TextView parametrs = (TextView)findViewById(R.id.parametrs);
        EditText pole = (EditText)findViewById(R.id.poleField);
        EditText obwod = (EditText)findViewById(R.id.obwodField);
        Button btnOK = ((Button)findViewById(R.id.Check));
        Button btnNext = ((Button)findViewById(R.id.button2));
        if(x){
            poleText.setVisibility(TextView.VISIBLE);
            obwodText.setVisibility(TextView.VISIBLE);
            parametrs.setVisibility(TextView.INVISIBLE);
            pole.setVisibility(EditText.INVISIBLE);
            obwod.setVisibility(EditText.INVISIBLE);
            btnOK.setVisibility(Button.INVISIBLE);
            btnNext.setVisibility(Button.VISIBLE);
        }
        else {
            poleText.setVisibility(TextView.INVISIBLE);
            obwodText.setVisibility(TextView.INVISIBLE);
            parametrs.setVisibility(TextView.VISIBLE);
            pole.setVisibility(EditText.VISIBLE);
            obwod.setVisibility(EditText.VISIBLE);
            btnNext.setVisibility(Button.INVISIBLE);
            btnOK.setVisibility(Button.VISIBLE);
        }
    }

}