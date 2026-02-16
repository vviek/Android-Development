package com.sourabh.recyclerview;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView=findViewById(R.id.recyclercontact);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));//set layout mananager and call the object of linear layout managar

        ArrayList<ContectModel>  arrcontect = new ArrayList<>();

        arrcontect.add(new ContectModel(R.drawable.img1,"A", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"b", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"c", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"A", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"b", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"c", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"A", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"b", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"c", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"A", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"b", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"c", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"A", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"b", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"c", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"A", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"b", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"c", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"A", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"b", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"c", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"A", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"b", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"c", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"A", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"b", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"c", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"A", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"b", "88888888"));
        arrcontect.add(new ContectModel(R.drawable.img1,"c", "88888888"));

        RecyclerContectAdopter adopter = new RecyclerContectAdopter(this, arrcontect);

        recyclerView.setAdapter(adopter);

        //  floating action button

        FloatingActionButton btnopenDialog;
        btnopenDialog = findViewById(R.id.fabAdd);

        btnopenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 //making couston dialog
                Dialog dialog =new Dialog(MainActivity.this);//caling tha object of dialog calsss ,parameter showing that dilog apare in this asctivity
                dialog.setContentView(R.layout.activity_add_updatets);//conecting tha layout that is made for dialog

                //connecting all view that are use
                EditText edtnamediaglo = dialog.findViewById(R.id.edtnamediaglo) ;
                EditText  edtnumberdialog  = dialog.findViewById(R.id.edtnumberdialog)  ;
                Button  submitaction = dialog.findViewById(R.id. submitDialog);


                //now submit button on click some acton perform using setonclicklistner

                submitaction.setOnClickListener(new View.OnClickListener() {
                    String name;
                    String number;
                    @Override


                    public void onClick(View view) {

                           name = edtnamediaglo.getText().toString();


                         number = edtnumberdialog.getText().toString();

                        arrcontect.add(new ContectModel(R.drawable.img1,name,number));//taking value in array


                        adopter.notifyItemInserted(arrcontect.size()-1);//adding value in adopter in last position
                        recyclerView.scrollToPosition(arrcontect.size()-1);//scrolling to last insert element

                        dialog.dismiss();//to remove dilog  from screenafter adding details

                          // notice the data is store during only in run time after reopen the app therer is no data
                        //because there is no data base connection now
                    }
                });

                dialog.show();


            }
        });



    }
}