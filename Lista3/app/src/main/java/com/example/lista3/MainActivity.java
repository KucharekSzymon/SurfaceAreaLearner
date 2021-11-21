package com.example.lista3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
            case "Zaloguj":
                pref(view);
                break;

            default:
                break;
        }
    }
    public void pref(View view){
        EditText login = findViewById(R.id.editTextTextPersonName);
        String logon = login.getText().toString();
        SharedPreferences preferences = getSharedPreferences("Prefs",MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(logon,logon);
        editor.commit();
    }
}
