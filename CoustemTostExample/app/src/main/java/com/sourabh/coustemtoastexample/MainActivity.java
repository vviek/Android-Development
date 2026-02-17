package com.sourabh.coustemtoastexample;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
  // making the object of toast class
        Toast toast = new Toast(this);

    //converting coustom layout to view and take in one variable using layoutinflate

     View view = getLayoutInflater().inflate(R.layout.coustem_toast_layout,(ViewGroup)findViewById(R.id.rootlayout));
        // view  is connected to toast
        toast.setView(view);
//to change text in runtime
        
        TextView dataView=view.findViewById(R.id.textData);
        dataView.setText("Hello Data Changed");

        // set the duration of toast mesage
     toast.setDuration(Toast.LENGTH_LONG);

     //this is the main method place you want to toast the massage
        toast.show();
    }
}