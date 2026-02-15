package com.sourabh.recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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



    }
}