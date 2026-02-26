package com.example.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                         SharedPreferences pref = getSharedPreferences("login",MODE_PRIVATE);
                         boolean check = pref.getBoolean("flag",false);

                    Intent inext ;


                         if(check){

                             inext = new Intent(MainActivity.this, home_activity.class);

                         }else{
                             inext = new Intent(MainActivity.this, login_activity.class);

                         }

                         startActivity(inext);

                }
            }, 2999);
        }


    }
}