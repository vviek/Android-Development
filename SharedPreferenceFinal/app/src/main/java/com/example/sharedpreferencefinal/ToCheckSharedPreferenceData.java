package com.example.sharedpreferencefinal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ToCheckSharedPreferenceData extends AppCompatActivity {

    TextView etusername2,password2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_check_shared_preference_data);

      // no need of editter to getdata form sharedpreference
        SharedPreferences sp = getSharedPreferences("mysp",MODE_PRIVATE);

        // to take value from sharedpreference make varible and take data according to key
        String username = sp.getString("username","defaltvalue");
        String password = sp.getString("password","defaltvalue");

         etusername2.setText(username);
         password2.setText(password);


    }
}