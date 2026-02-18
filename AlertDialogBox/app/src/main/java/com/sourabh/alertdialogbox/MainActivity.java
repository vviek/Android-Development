package com.sourabh.alertdialogbox;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// alert dialog for single button
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        alertDialog.setTitle("Terms & Conditions");
         alertDialog.setIcon(R.drawable.outline_arrow_insert_24);
         alertDialog.setMessage("Have you Read All T & C ");

       alertDialog.setButton("yes i am read", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialogInterface, int i) {
               Toast.makeText(MainActivity.this, "yes you can process now..", Toast.LENGTH_SHORT).show();
           }
       });
 // it show dialog
       alertDialog.show();

 // for 2  button dialog
 AlertDialog.Builder alertdialogBuilder = new AlertDialog.Builder(this)   ;

        alertdialogBuilder.setIcon(R.drawable.outline_auto_delete_24);
        alertdialogBuilder.setTitle("Delet ? ") ;
        alertdialogBuilder.setMessage("are you sure want to delete") ;

        alertdialogBuilder.setPositiveButton("yes ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "item deleted", Toast.LENGTH_SHORT).show();
            }
        });

        alertdialogBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "item not deleted", Toast.LENGTH_SHORT).show();
            }
        }) ;

                //  it is imp
        alertdialogBuilder.show();


       // on back press button it ask to are you sure want to exit app
      getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
          @Override
          public void handleOnBackPressed() {

              AlertDialog.Builder  exitbuilder = new AlertDialog.Builder(MainActivity.this);


              exitbuilder.setIcon(R.drawable.img);
              exitbuilder.setTitle("EXIT");
              exitbuilder.setMessage("are you sure want to exit app ");

              exitbuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                  }
              });

              exitbuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {
                      Toast.makeText(MainActivity.this, "well come back", Toast.LENGTH_SHORT).show();
                  }
              });

              exitbuilder.setNeutralButton("cancle", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {
                      Toast.makeText(MainActivity.this, "operation cancle", Toast.LENGTH_SHORT).show();
                  }
              });

              exitbuilder.show();


          }
      });
    }
}