package com.sourabh.toolbaroractionbar;

import static android.widget.Toast.LENGTH_SHORT;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Toolbar mytoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mytoolbar=findViewById(R.id.mytoolbar);


      // step 1---> linking toolbar to java file
        setSupportActionBar(mytoolbar);

        // 3 operatin  set title in tool bar


     //step 2 --> operation given by android in tool bar
     //1 operation back button in toolbar using method provid by android
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        // 3 operatin  set title in tool bar
        getSupportActionBar().setTitle("Tool");

     //2 menu
     //setup menu operation

        //method first


    }

    //method first
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //connecting the menu
        new MenuInflater(this).inflate(R.menu.opt_nemu,menu);

        return super.onCreateOptionsMenu(menu);
    }
//METHOD second used to perform operation on clicking on items
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //this method is giving item so using item it on clicking on runtime taking id on click item in variale
        int itemid = item.getItemId();// taking id during runtime

        // make condition for all item and do what operation want to perdorm
        if(itemid==R.id.item1){

            Toast.makeText(this,"NEW FILE ",LENGTH_SHORT).show();
        } else if (itemid==R.id.item2) {
            Toast.makeText(this,"FILE OPENED ",LENGTH_SHORT).show();
        } else if (itemid==R.id.item3) {
            Toast.makeText(this,"SAVED FILE",LENGTH_SHORT).show();
        }
        else {
            //IT IS FOR BACK SYMBOL IN TOOL BAR
            getOnBackPressedDispatcher().onBackPressed();

        }
        return super.onOptionsItemSelected(item);
    }
}