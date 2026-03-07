package com.example.databasesqllite;

import android.database.sqlite.SQLiteDatabase;
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

            // callig that function i make in mydb calsss to add value in table

            MyDB db = new MyDB(this);
            db.AddDataInTable(1,"sourabh","8827467391");
            db.AddDataInTable(2,"neetin"," 7439587071");
            db.AddDataInTable(3,"vivek","9993821365");

    }
}