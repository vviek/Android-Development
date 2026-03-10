package com.example.sqliteoperationsexample1;

import android.database.sqlite.SQLiteDatabase;
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

              MyDb myDbObject = new MyDb(MainActivity.this);
              myDbObject.insertvalueInTable(1,"B.tech",9.8);
              myDbObject.insertvalueInTable(2,"B.com",8.3);
             myDbObject.insertvalueInTable(3,"B.sc",7.3);
             myDbObject.insertvalueInTable(4,"B.sc",5.3);
             
             myDbObject.insertvalueInTable(5,"B.sc",3.3);
        myDbObject.insertvalueInTable(6,"B.tech",9.8);
        myDbObject.insertvalueInTable(7,"B.com",8.3);
        myDbObject.insertvalueInTable(8,"B.sc",7.3);
        myDbObject.insertvalueInTable(9,"B.sc",5.3);
        myDbObject.insertvalueInTable(10,"B.sc",3.3);






        //last step

    }
}