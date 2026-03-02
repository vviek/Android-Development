package com.example.retrofitexample1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //1
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://portal.cheetahforce.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        //2 make interface

        //3
       RetroInterface api = retrofit.create(RetroInterface.class);


       //4
        Call<String> call = api.getData();








    }
}