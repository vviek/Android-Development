package com.example.taskbyvivek;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login_activity extends AppCompatActivity {

    TextView regsterpage,forgetpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        regsterpage = findViewById(R.id.regsterpage);


        // click on registion page

        regsterpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent iresgesterpage;
                iresgesterpage = new Intent(login_activity.this, register_activity.class);
                startActivity(iresgesterpage);

            }
        });

        // click on forget password
        forgetpassword = findViewById(R.id.forgetpassword);
        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog = new Dialog(login_activity.this);
                dialog.setContentView(R.layout.email_dialog);

                dialog.show();


                   Button btnCancel;
                   btnCancel = dialog.findViewById(R.id.btnCancel);


                   // cancle button in dialog box
                   btnCancel.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           dialog.dismiss();
                       }
                   });

            }
        });
    }
}