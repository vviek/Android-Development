package com.example.taskbyvivek;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Calendar;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class register_activity extends AppCompatActivity {

     Button btnClear,btnSubmit;
    EditText etName, etEmail, etDOB, etPassword, etMobile, etAddress;
    EditText etusername;
    CheckBox cbAdmin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnClear=findViewById(R.id.btnClear);
        btnSubmit=findViewById(R.id.btnSubmit);

        etName = findViewById(R.id.etName);
        etusername = findViewById(R.id.etusername);

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
                etusername.setText("");
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




btnSubmit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        if (etName.getText().toString().isEmpty() || etusername.getText().toString().isEmpty() || etEmail.getText().toString().isEmpty() ||
                etDOB.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty() || etMobile.getText().toString().isEmpty()
                || etAddress.getText().toString().isEmpty()) {

            Toast.makeText(register_activity.this, "Please fill all details", Toast.LENGTH_SHORT).show();

        } else {


            // api

      /*  http://localhost/learn_app_api/register.php
        {
            "name": "Sagar Lurmi",
                "email_id": "sagar@gmail.com",
                "password": "123456",
                "username": "sagar123",
                "is_admin": 0,
                "date_of_birth": "1995-05-15",
                "mobile": "9876543210",
                "address": "Bhopal, India"
        }

        */

            //1

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.1.6/learn_app_api/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();


            //2 create interface
            // 3
            RetroFitInterface apisrever = retrofit.create(RetroFitInterface.class);


            // 4
            String name = etName.getText().toString();
            String email = etEmail.getText().toString();
            boolean isadmin = cbAdmin.isChecked();
            String dob = etDOB.getText().toString();
            String password = etPassword.getText().toString();
            String usernme = etusername.getText().toString();
            String number = etMobile.getText().toString();
            String address = etAddress.getText().toString();


            // format of json given by api developer
              /*  http://localhost/learn_app_api/register.php
        {
            "name": "Sagar Lurmi",
                "email_id": "sagar@gmail.com",
                "password": "123456",
                "username": "sagar123",
                "is_admin": 0,
                "date_of_birth": "1995-05-15",
                "mobile": "9876543210",
                "address": "Bhopal, India"
        }

        */

            //5
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("name", name);
                jsonObject.put("email_id", email);
                jsonObject.put("admain", isadmin);
                jsonObject.put("date_of_birth", dob);
                jsonObject.put("password", password);
                jsonObject.put("username", usernme);
                jsonObject.put("mobile", number);
                jsonObject.put("address", address);


            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

//6
            String jsonString = jsonObject.toString();
            RequestBody body = RequestBody.create(jsonString, MediaType.parse("application/json"));


//7
            Call<ResponseBody> Call = apisrever.registeruse(body);


            //8
            // now  below the api response code
            Call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    try {
                        String finalresponse = response.body().string();
                        Log.e("result ", "api response" + finalresponse);

                        JSONObject jsonObject1 = new JSONObject( finalresponse);
                        boolean status1 = jsonObject1.getBoolean("status");
                        if(status1) {

                            Toast.makeText(register_activity.this, "Registation is Success", Toast.LENGTH_LONG).show();

                            etName.setText("");
                            etusername.setText("");
                            etEmail.setText("");
                            etDOB.setText("");
                            etPassword.setText("");
                            etMobile.setText("");
                            etAddress.setText("");
                            cbAdmin.setChecked(false);


                            Intent inexthome;
                            inexthome = new Intent(register_activity.this, login_activity.class);
                            startActivity(inexthome);


                        }else {

                            Toast.makeText(register_activity.this, "user all ready exit , plz change the gmail ", Toast.LENGTH_LONG).show();


                        }
                    } catch (Exception e) {
                        Log.e("trycatch", "problem on trycatch" + e);
                        throw new RuntimeException(e);
                    }

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                    Log.e("fail", "api fail" + t);

                }
            });


        }
    }
});



    }
}