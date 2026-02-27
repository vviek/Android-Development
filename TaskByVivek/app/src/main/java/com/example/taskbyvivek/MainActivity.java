package com.example.taskbyvivek;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnLogin,btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin =findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        // 1 btn
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iloginpage;
                iloginpage = new Intent(MainActivity.this, login_activity.class);
                startActivity(iloginpage);

            }
        });

        // 2 btn
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iregister;
                iregister=new Intent(MainActivity.this, register_activity.class);
                startActivity(iregister);

            }
        });





    }
}