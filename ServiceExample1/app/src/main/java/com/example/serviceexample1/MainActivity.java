package com.example.serviceexample1;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mention service in in mainfests file

        // step 1 make a class that extends service class  and some method you have to override

        //6 make button to control servise we can also put in oncreate so when app open it work

        //7
          Button stService,stopService;
        stService= findViewById(R.id.stService);
        stopService=findViewById(R.id.StopService);

         // start service
        stService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 // 8  for start service
                  Intent intent = new Intent(MainActivity.this, MusicService.class);
                  startService(intent);


            }
        });


        //stop service
        stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //8 for stop services
                Intent intent = new Intent(MainActivity.this, MusicService.class);
                stopService(intent);

            }
        });

        // 9  in service calss  set return


    }
}