package com.example.taskbyvivek;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.taskbyvivek.RetrofitLoginInterface;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class login_activity  extends AppCompatActivity {

    TextView etUsername,etPassword,tvForgotPassword,tvRegister;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);
        btnLogin=findViewById(R.id.btnLogin);
        tvForgotPassword=findViewById(R.id.tvForgotPassword);
        tvRegister=findViewById(R.id.tvRegister);


       // cretae new account button
        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoregisterpage;
                gotoregisterpage = new Intent(login_activity.this, register_activity.class);
                startActivity(gotoregisterpage);
                finish();
            }
        });

        // for login button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                       if(etUsername.getText().toString().isEmpty() && etPassword.getText().toString().isEmpty()){
                           Toast.makeText(login_activity.this,"plz enter your username and password ",Toast.LENGTH_SHORT).show();
                       return ;
                       }
                       if (etUsername.getText().toString().isEmpty()) {
                           Toast.makeText(login_activity.this,"plz enter your user username ",Toast.LENGTH_SHORT).show();
                        return;
                       }

                       if (etPassword.getText().toString().isEmpty())  {

                           Toast.makeText(login_activity.this,"plz enter your  password ",Toast.LENGTH_SHORT).show();
                       return;
                       }
                     // http://localhost/learn_app_api/login.php
                       //{
                       //    "username":"vivek123",
                       //    "password":"123456"
                       //}
                       //192.168.1.6

                       //1  Get input values
                       String username = etUsername.getText().toString();
                       String passwords = etPassword.getText().toString();


                       //2   Create JSON
                       JSONObject jsonObject = new JSONObject();
                       try {
                           jsonObject.put("username", username);
                           jsonObject.put("password", passwords);
                       } catch (JSONException e) {
                           throw new RuntimeException(e);
                       }

                       //3
                       String jsonString = jsonObject.toString();

                       //4  conver to requestbody
                       RequestBody requestBody = RequestBody.create(jsonString, MediaType.parse("application/json"));


                       // 5 Create Retrofit instance
                       Retrofit retrofit = new Retrofit.Builder()
                               .baseUrl("http://192.168.1.6/learn_app_api/")
                               .addConverterFactory(GsonConverterFactory.create())
                               .build();


                       //6 connecting interface
                       RetrofitLoginInterface apiserver = retrofit.create(RetrofitLoginInterface.class);


                       //7 Call API
                       Call<ResponseBody> call = apiserver.postRawJson(requestBody);
                       call.enqueue(new Callback<ResponseBody>() {
                           @Override
                           public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                               // json parsing
                               try {
                                   String result = response.body().string();
                                   Log.e("res", "onResponse:returnvalue " + result);
                                   JSONObject finalobj = new JSONObject(result);
                                   String status = finalobj.getString("status");
                                   boolean isStstus = Boolean.parseBoolean(status);


                                   // login intents
                                   if (isStstus) {
                                       JSONObject jsonObjects = finalobj.getJSONObject("user_details");
                                       int checkboxStatus = jsonObjects.getInt("is_admin");
                                       Log.e("checkbox", "finalresponse:check box ststus " + checkboxStatus);

                                       if (checkboxStatus == 1) {
                                           Intent isAdmin;
                                           isAdmin = new Intent(login_activity.this, Admin_activity.class);
                                           startActivity(isAdmin);
                                           finish();
                                       } else {
                                           Intent tohome;
                                           tohome = new Intent(login_activity.this, Home_activity.class);
                                           startActivity(tohome);
                                           finish();
                                       }
                                   }else{

                                       Log.e("notlogin","login ststus"+isStstus);
                                       Toast.makeText(login_activity.this,"plz register first",Toast.LENGTH_SHORT).show();

                                   }



                               } catch (Exception e) {
                                   Log.e("catch", "onResponse:returnvalue " + e);
                                   throw new RuntimeException(e);
                               }

                           }

                           @Override
                           public void onFailure(Call<ResponseBody> call, Throwable t) {
                               Log.e("api", "onResponse:api fail " + t);

                           }
                       });
                   }


        });


        // for forget password

        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(login_activity.this);
                dialog.setContentView(R.layout.email_dialog);

               Button btnCancel;
               btnCancel=dialog.findViewById(R.id.btnCancel);

       // for cancle button
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();

                    }
                });
          // for sentcode
                Button btnSendCode;
                btnSendCode=dialog.findViewById(R.id.btnSendCode);

                btnSendCode.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(login_activity.this,"Code is send to your email id",Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.show();
            }
        });






    }
}

