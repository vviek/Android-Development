package com.sourabh.coustemalertbox;

import android.app.ActionBar;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

        Button mainBtn = findViewById(R.id.mainBtn);

        // make the object of dialg class
        Dialog dialog = new Dialog(this);


        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //connecting coustem layout to dialog
                dialog.setContentView(R.layout.coustem_alert_dialog);

                // it is coustem dialog so it not automatic close have to make btn and set on click listener and use .dissmesh()
                Button okbtn = dialog.findViewById(R.id.oktbtn);
                okbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this,"placed order ",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                //show
                dialog.show();
            }
        });


/*
        // make the object of dialg class
        Dialog dialog = new Dialog(this);

        //connecting coustem layout to dialog
        dialog.setContentView(R.layout.coustem_alert_dialog);

        // it is coustem dialog so it not automatic close have to make btn and set on click listener and use .dissmesh()
        Button okbtn = dialog.findViewById(R.id.oktbtn);
        okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"placed order ",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        //show
        dialog.show();*/

    }
}