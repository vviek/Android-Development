package com.example.tablayout;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    //step3
    TabLayout tab;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //step4 ,step 5 = make required fragment according to tab item
         tab = findViewById(R.id.tablayout);
         viewPager = findViewById(R.id.viewpager);

         //imp part
        //make viewpager adopter that extends Fragmentpageradopter
        //next step in inside adopter
        //adding item in tab inside adopter by using method = getPageTitle

        //step 9
        //calling the adopter by creating the object with consterecter paremeter getsupportfragmentmanager
        //and also connecting the view pager with abopter
        ViewPagerMassangerAdopter adopter = new ViewPagerMassangerAdopter(getSupportFragmentManager());
        viewPager.setAdapter(adopter);

        //last step 10
        //connecting tab with view pager with .setupwithviewpager()
        tab.setupWithViewPager(viewPager);




    }
}