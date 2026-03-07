package com.example.databasesqllite;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

// 1 = extends the class with SQLiteOpenHelper which give two override method and constructor
public class MyDB extends SQLiteOpenHelper {

    // alwalys put static and final to database name


    // 3
    private static final String DATABASE_NAME = "contacteDB";
    private static final int DATABASE_VERSION= 1;

    //tablle name
    private static final String Table_contect = "contect";
    //coloum names
    private static final String key_id="id";
    private static final String key_name="name";
    private static final String key_number="number";


//2
    public MyDB(@Nullable Context context) {
        //put factory = null
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        // Query to create table and parameter in oncreate method is database
    }


    // 5 now database is create automatically
    @Override
    public void onCreate(SQLiteDatabase db) {

        //4
        //  Query to create table and parameter in oncreate method is database write query inside db.execSql();
        //datatype = integer or text
        // put coloum name in varable and use in queary
        //  SQL query = create table tablename (c1 datatype ,c2 datatpe,c3 datatype)
        // space after create tabele



        db.execSQL(" CREATE TABLE "+ Table_contect  + "(" + key_id  +  "integer  PRIMARY KEY ," + key_name  + "text," + key_number + "text" + " );" );

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        // this method is called when to updatedatabase
        db.execSQL("drop table if exists " + Table_contect);
        //calling oncreate method to again bulid table
        onCreate(db);

    }

    public void AddDataInTable(int id,String name,String number){

        // open database
        SQLiteDatabase db = this.getWritableDatabase();

        // create object of ContentValues class and put connection to put value
        ContentValues value = new ContentValues();
        value.put(key_id,id);
        value.put(key_name,name);
        value.put(key_number,number);

        // defining in which table value has to insert
        db.insert(DATABASE_NAME,null,value);

        // close the database
        db.close();
    }
}
