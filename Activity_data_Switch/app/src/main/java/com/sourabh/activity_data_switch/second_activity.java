package com.sourabh.activity_data_switch;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class second_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        Intent  fromactivity = getIntent();
        String title= fromactivity.getStringExtra("title");
        String name= fromactivity.getStringExtra("Name");
        int  rullno=fromactivity.getIntExtra("ROLL NO",0);

        TextView txtname;

        txtname=findViewById(R.id.txtname);
        txtname.setText("name : "+name+ "  |  "  +"roll no : "+rullno);





    }
}