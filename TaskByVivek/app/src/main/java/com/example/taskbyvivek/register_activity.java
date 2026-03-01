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

import org.json.JSONObject;

import java.util.Calendar;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class register_activity extends AppCompatActivity {

     Button btnClear,btnSubmit;
    EditText etName, etEmail, etDOB, etPassword, etMobile, etAddress,username;
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
        username = findViewById(R.id.etuserName);

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



        // api
       // IPv4 Address. . . . . . . . . . . : 192.168.1.9
        //http://localhost/learn_app_api/register.php
      /* {
            "name": "Sagar Lurmi",
                "email_id": "sagar@gmail.com",
                "password": "123456",
                "username": "sagar123",
                "is_admin": 0,
                "date_of_birth": "1995-05-15",
                "mobile": "9876543210",
                "address": "Bhopal, India"
        } */

        //1

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.2/learn_app_api/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        //2 interface

        //3
        RetrofitRegisterInterface api = retrofit.create(RetrofitRegisterInterface.class);




        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if (etName.getText().toString().trim().isEmpty() ||
                        etEmail.getText().toString().trim().isEmpty() ||
                        etPassword.getText().toString().trim().isEmpty() ||
                        etDOB.getText().toString().trim().isEmpty() ||
                        etMobile.getText().toString().trim().isEmpty() ||
                        etAddress.getText().toString().trim().isEmpty() ||
                        username.getText().toString().trim().isEmpty()) {

                    Toast.makeText(register_activity.this,
                            "Please fill all fields",
                            Toast.LENGTH_LONG).show();
                } else {
                //4
                //taking the value the use type and i have define in interface calss
                String name =    etName.getText().toString();
                String email= etEmail.getText().toString();
                String password =   etPassword.getText().toString();
                String usernames=username.getText().toString();
                int isAdmin = cbAdmin.isChecked() ? 1 : 0;
                String dobs =   etDOB.getText().toString();
                String mobile = etMobile.getText().toString();
                String adress =  etAddress .getText().toString();



                    JSONObject jsonObject = new JSONObject();
                    try {

                        jsonObject.put("name", name);
                        jsonObject.put("email_id", email);
                        jsonObject.put("password", password);
                        jsonObject.put("username", usernames);
                        jsonObject.put("is_admin", isAdmin);
                        jsonObject.put("date_of_birth", dobs);
                        jsonObject.put("mobile", mobile);
                        jsonObject.put("address", adress);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    String jsonString = jsonObject.toString();
                    RequestBody body = RequestBody.create(jsonString, MediaType.parse("application/json"));
                    Call<String> call = api.registerNewUser(body);
                    //6
                /*Call<String> call = api.registerUser(
                        name, email, password, usernames,
                        isAdmin, dobs, mobile, adress
                );*/

                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {


                        if (response.isSuccessful() && response.body() != null) {

                            try {

                                String jsonResponse = response.body();

                                JSONObject jsonObject = new JSONObject(jsonResponse);

                                boolean status = jsonObject.getBoolean("status");
                                String message = jsonObject.getString("message");

                                if (status) {

                                    Toast.makeText(
                                            register_activity.this, message, android.widget.Toast.LENGTH_LONG).show();

                                } else {
                                    Log.e("API_RESPONSE_FAIL", "Response: " + jsonResponse);

                                    Toast.makeText(register_activity.this,message, android.widget.Toast.LENGTH_LONG).show();
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }



                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                        Toast.makeText(register_activity.this,
                                "Error: " + t.getMessage(),
                                Toast.LENGTH_LONG).show();

                        Log.e("API_ERROR", "onFailure: ", t);



                    }
                });



            }
            }

        });




    }
    }
