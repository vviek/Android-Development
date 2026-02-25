package com.example.retrofitexample1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView;
        listView=findViewById(R.id.listview);

        ArrayList<String> arrayList = new ArrayList<>();

     //1
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://portal.cheetahforce.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();


        //2 create interfcae

        //3
        RetroFitInterface api = retrofit.create(RetroFitInterface.class);

        //4
        Call<String> call =api.getData();


        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                  String data = response.body();

                try {
                    JSONObject obj = new JSONObject(data);
                    JSONArray jsonArray = obj.getJSONArray("Android");
                      for(int i=0;i<jsonArray.length();i++) {

                          JSONObject finaldata = jsonArray.getJSONObject(i);
                          String name = finaldata.getString("name");

                          arrayList.add(name);
                      }


                    ArrayAdapter arrAdopter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,arrayList);
                      listView.setAdapter(arrAdopter);

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });





    }
}