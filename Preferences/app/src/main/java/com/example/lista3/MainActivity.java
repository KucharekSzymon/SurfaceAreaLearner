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
        Intent Login = new Intent(MainActivity.this, Test.class);
        EditText lgn = findViewById(R.id.editTextTextPersonName);
        Login.putExtra("Login",lgn.getText().toString());
        startActivity(Login);
    }
}
