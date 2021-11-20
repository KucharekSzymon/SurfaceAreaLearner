package com.example.lista3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ButtonClick(View view)
    {
        String ButtonText;
        ButtonText = ((Button) view).getText().toString();
        switch (ButtonText)
        {
            case "Learning":
                Intent LEarn = new Intent(MainActivity.this, Learning.class);
                startActivity(LEarn);
                break;
            case "Test":
                Intent Test = new Intent(MainActivity.this, Test.class);
                startActivity(Test);
                break;
            default:
                break;
        }
    }
}