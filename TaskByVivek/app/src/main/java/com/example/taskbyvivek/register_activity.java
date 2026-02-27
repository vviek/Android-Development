package com.example.taskbyvivek;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class register_activity extends AppCompatActivity {

     Button btnClear,btnSubmit;
    EditText etName, etEmail, etDOB, etPassword, etMobile, etAddress;
    CheckBox cbAdmin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnClear=findViewById(R.id.btnClear);
        btnSubmit=findViewById(R.id.btnSubmit);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etDOB = findViewById(R.id.etDOB);
        etPassword = findViewById(R.id.etPassword);
        etMobile = findViewById(R.id.etMobile);
        etAddress = findViewById(R.id.etAddress);
        cbAdmin = findViewById(R.id.cbAdmin);
        btnClear = findViewById(R.id.btnClear);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etName.setText("");
                etEmail.setText("");
                etDOB.setText("");
                etPassword.setText("");
                etMobile.setText("");
                etAddress.setText("");

                cbAdmin.setChecked(false);


            }
        });

        //  for clander
        EditText etDOB = findViewById(R.id.etDOB);

        etDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        register_activity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(android.widget.DatePicker view,
                                                  int selectedYear,
                                                  int selectedMonth,
                                                  int selectedDay) {

                                Calendar selectedDate = Calendar.getInstance();
                                selectedDate.set(selectedYear, selectedMonth, selectedDay);

                                java.text.SimpleDateFormat sdf =
                                        new java.text.SimpleDateFormat("d MMM yyyy");

                                String formattedDate = sdf.format(selectedDate.getTime());
                                etDOB.setText(formattedDate);
                            }
                        },
                        year, month, day
                );

                // Prevent future date selection
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

                datePickerDialog.show();
            }
        });



        // 

    }
}