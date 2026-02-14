package com.sourabh.activity_data_switch;

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
        Button btnNEXT;
        btnNEXT=findViewById(R.id.btnnext);

        Intent iNext;
        iNext = new Intent(MainActivity.this,second_activity.class);

        iNext.putExtra("title","HOME");
        iNext.putExtra("ROLL NO",20);
        iNext.putExtra("Name","sourabh");

        btnNEXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(iNext);

            }
        });



    }
}