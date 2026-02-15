package com.sourabh.yourvanity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Intro_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screen);

        Intent ihome = new Intent(Intro_screen.this,MainActivity.class);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

               startActivity(ihome);
               finish();

            }
        } ,2000 );

    }
}