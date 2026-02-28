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

               // to use database and and insert value in table
                // make  the variable and take the referencer of database

         // to use data base from the activity firt make the object of batabase class

        //imp   ===  for using database first open database  in last close database

        // open   database
        MyDB myDBobj = new MyDB(this);
        SQLiteDatabase database = myDBobj.getWritableDatabase();    // in database calss on wite this SqliteDatabase database = this.getwiteable or this.getreadable



        // set of operation want to perform like
        // query you want to perform
        //database.insert()   that type of operatin

        //close database
        database.close();
    }
}