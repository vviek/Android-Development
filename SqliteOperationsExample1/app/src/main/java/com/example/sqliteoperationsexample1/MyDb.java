package com.example.sqliteoperationsexample1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDb extends SQLiteOpenHelper {


    //1
    private static final String DATABASE_NAME="student";

    private static final  int DataBase_Version = 1;


    //2
    public static  final String  Table_Details = "details";
    public static final String key_RollNo ="Rollno";
    public static final String  key_course="course";
    public static final String key_Cgpa ="cgpa";




    public MyDb(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DataBase_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // create table
        // datatype int,text
        // Sql = create table tablename ( c1name datatype,c2name datatype,c3name datatype);
        // 3
        // create table tablename (c1 dataype,c2 datatype,c3 datatype);
        db.execSQL(  "CREATE TABLE " + Table_Details + " (" +
                key_RollNo+ " INTEGER PRIMARY KEY , " +
                key_course + " TEXT NOT NULL, " +
                key_Cgpa + " REAL);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Details);
        onCreate(db);

    }
    // To insert value in databse make function
    public void insertvalueInTable(int rollno,String course, double cgpa){

        // open database
        SQLiteDatabase sqdb = this.getWritableDatabase();

        // use contentvalues class  make the object
        // taking value in contentvalue object
        ContentValues values = new ContentValues();
          values.put(key_RollNo,rollno);
          values.put(key_course,course);
          values.put(key_Cgpa,cgpa);

          // inset all value in table
          sqdb.insert(Table_Details,null,values);

          sqdb.close();


    }
}
