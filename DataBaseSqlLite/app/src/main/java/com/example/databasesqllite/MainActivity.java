package com.example.databasesqllite;

import android.app.Dialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button deletdata;
    EditText etid, etname, etnumber;
    Spinner spinner;
    FloatingActionButton fab;
    float dX, dY;

    MyDB db;
    ArrayList<String> nameList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        etid = findViewById(R.id.etId);
        etname = findViewById(R.id.etName);
        etnumber = findViewById(R.id.etNumber);
        fab = findViewById(R.id.fabadd);
        spinner = findViewById(R.id.spinner);
        deletdata =findViewById(R.id.deletdata);

        // Initialize database
        db = new MyDB(this);

        // Initialize spinner list & adapter
        nameList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, nameList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Load initial spinner data
        loadSpinnerData();

        // Spinner selection
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedName = nameList.get(position);

                SQLiteDatabase sqdb = db.getReadableDatabase();
                Cursor c = sqdb.rawQuery("SELECT * FROM contect WHERE name=?", new String[]{selectedName});

                if(c.moveToFirst()){
                    etid.setText(String.valueOf(c.getInt(0)));
                    etname.setText(c.getString(1));
                    etnumber.setText(c.getString(2));
                }

                c.close();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Draggable FAB
        fab.setOnTouchListener(new View.OnTouchListener() {

            float startX, startY;
            boolean isClick;

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        dX = view.getX() - event.getRawX();
                        dY = view.getY() - event.getRawY();
                        startX = event.getRawX();
                        startY = event.getRawY();
                        isClick = true; // assume click initially
                        break;

                    case MotionEvent.ACTION_MOVE:
                        float deltaX = Math.abs(event.getRawX() - startX);
                        float deltaY = Math.abs(event.getRawY() - startY);

                        if (deltaX > 10 || deltaY > 10) { // threshold for drag
                            isClick = false;
                        }

                        view.animate()
                                .x(event.getRawX() + dX)
                                .y(event.getRawY() + dY)
                                .setDuration(0)
                                .start();
                        break;

                    case MotionEvent.ACTION_UP:
                        if (isClick) {
                            view.performClick(); // trigger click
                        }
                        break;

                    default:
                        return false;
                }
                return true;
            }
        });

        // FAB click → open dialog
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_details);

                EditText name = dialog.findViewById(R.id.etName);
                EditText number = dialog.findViewById(R.id.etNumber);
                Button submit = dialog.findViewById(R.id.btnSubmit);

                // Increase dialog size
                dialog.getWindow().setLayout(
                        (int)(getResources().getDisplayMetrics().widthPixels * 0.9),
                        (int)(getResources().getDisplayMetrics().heightPixels * 0.5)
                );

                // Submit button click
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String n = name.getText().toString().trim();
                        String num = number.getText().toString().trim();

                        if(!n.isEmpty() && !num.isEmpty()){
                            db.AddDataInTable(n,num);   // insert into SQLite
                            loadSpinnerData();           // refresh spinner
                            Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter name & number", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                dialog.show();
            }
        });


        deletdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDB db1 = new MyDB(MainActivity.this);
                        db1.DetletDataFromTable();
            }
        });

    }

    // Method to load spinner data
    private void loadSpinnerData() {
        SQLiteDatabase sqdb = db.getReadableDatabase();
        nameList.clear();
        Cursor cursor = sqdb.rawQuery("SELECT name FROM contect", null);
        while(cursor.moveToNext()){
            nameList.add(cursor.getString(0));
        }
        cursor.close();
        adapter.notifyDataSetChanged();
    }





}