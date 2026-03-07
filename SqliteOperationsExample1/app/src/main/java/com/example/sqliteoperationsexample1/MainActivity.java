package com.example.sqliteoperationsexample1;

import android.os.Bundle;

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


        //last step
        MyDb myDbObject = new MyDb(MainActivity.this);
        myDbObject.insertvalueInTable(1,"B.tech",9.8);
        myDbObject.insertvalueInTable(2,"B.com",8.3);

    }
}