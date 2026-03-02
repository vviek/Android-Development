package com.example.fragmentmehtod2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {


    Button frag1,frag2,frag3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        frag1=findViewById(R.id.fragA);
        frag2=findViewById(R.id.fragB);
        frag3=findViewById(R.id.fragC);

        //last step
        //making default fragment that open on app open
        FragmentManager fm=getSupportFragmentManager();
       FragmentTransaction ft =fm.beginTransaction();
       ft.add(R.id.container,new a_fragment());
       ft.commit();

        //1
        frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // every button have to these 4 line ,so we can make seprate function and call in buttons
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();


                //one parameter is framelayout id and 2 parameter is object on fragment layout we made
                ft.add(R.id.container, new a_fragment());
                //more option are .replace,.

                //imp
                ft.commit();
            }
        });

        //2
        frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();

                ft.add(R.id.container,new b_fragment());

                ft.commit();

            }
        });
        //3
        frag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();

                ft.add(R.id.container,new c_fragment());

                ft.commit();

            }
        });



    }
}