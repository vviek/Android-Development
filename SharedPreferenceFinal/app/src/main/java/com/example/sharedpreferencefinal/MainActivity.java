package com.example.sharedpreferencefinal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    EditText etUsername,etPassword;
    Button loginbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        loginbtn = findViewById(R.id.btnLogin);



        // creating shared preference
        SharedPreferences sp = getSharedPreferences("mysp",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        // stroing value in sahred preference
        editor.putString("username",etUsername.getText().toString());
        editor.putString("password",etPassword.getText().toString());
        editor.apply();



        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext;
                inext = new Intent(MainActivity.this, ToCheckSharedPreferenceData.class);
                startActivity(inext);
            }
        });



    }
}