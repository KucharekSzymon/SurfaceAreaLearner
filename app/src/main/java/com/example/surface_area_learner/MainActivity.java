package com.example.surface_area_learner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TableRow;

public class MainActivity extends Activity
{
    public void buttonPress(View view){
        String choice;
 //       Switch x = (Switch) findViewById(R.id.switch1);
//        Log.d("Chceck",String.valueOf(x.isChecked()));
        switch (choice){
            case "Menu":
                setContentView(R.layout.activity_main);
                break;
            case "Trapezoid":
                setContentView(new Trapezoid(this));
                break;
            case "Triangle":
                setContentView(new Triangle(this));
                break;
            case "Square":
                setContentView(new Rectangle(this,100,100));
                break;
            case "Rectangle":
                setContentView(new Rectangle(this,300,50));
                break;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(new Rectangle(this,200,80));
    }


}