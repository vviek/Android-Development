package com.example.bottomnavigation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //step 5 place bnview,step 6 = make fragment
        BottomNavigationView bnview;

        setContentView(R.layout.activity_main);

        bnview =findViewById(R.id.bnview);
        //step 9 set defautl fragment opent first time

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        // two parameter required id of container and  object of fragment layouy
        ft.add(R.id.container,new profileFragment());
        ft.commit();

        // last step for highlite item defalt open
        bnview.setSelectedItemId(R.id.profile);


        //step 7
        //seting  click on icone inside bottom navation view  if we use onclicklistner will set on hole bottom navagation
        //so on seleted item inside bn we use setOnNavigationItemSelectLisy..  ,parameter objecj of same class

        bnview.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                //step 8 set fragment according to id


                //step 10 ( optional )= note == we can add ft.replace because when fragment load it over lap so remove over lap we use
                //making mathod and adding if condiyion

                int id = menuItem.getItemId();
                if(id==R.id.home){
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft= fm.beginTransaction();
                    // two parameter required id of container and  object of fragment layouy
                    ft.add(R.id.container,new homeFragment());
                    ft.commit();


                } else if (id==R.id.search) {
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();

                    ft.add(R.id.container,new searchFragment());
                    ft.commit();

                } else if (id==R.id.utility) {

                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft =fm.beginTransaction();

                    ft.add(R.id.container,new utilityFragment());
                    ft.commit();

                } else if (id==R.id.contectus) {

                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();

                    ft.add(R.id.container,new contectFragment());
                    ft.commit();

                }else {

                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft= fm.beginTransaction();

                    ft.add(R.id.container,new profileFragment());
                    ft.commit();

                }

                // true we put return true it highlite the icone which is selected,to impact on botton navigartion which one is selected
                return  true;

            }

        });


        



    }
}