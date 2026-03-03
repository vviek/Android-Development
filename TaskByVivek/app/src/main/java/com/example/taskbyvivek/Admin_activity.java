package com.example.taskbyvivek;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Admin_activity extends AppCompatActivity {

    RecyclerView admainRecyclerview;
    ArrayList<ModelClassForRecyclerview> arruserDetalis;
    RecyclerContectAdopter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        //
        admainRecyclerview = findViewById(R.id.admainRecyclerview);

        admainRecyclerview.setLayoutManager(new LinearLayoutManager(this));

        arruserDetalis = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.6/learn_app_api/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        interfaceOfAdmainApi api = retrofit.create(interfaceOfAdmainApi.class);

        Call<String> call = api.getdata();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                String responsedata = response.body();
                Log.e("getapi","response of get api"+responsedata);

                try {
                    JSONObject jsonObject = new JSONObject(responsedata);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject obj = jsonArray.getJSONObject(i);

                        String name = obj.getString("name");
                        String email_id = obj.getString("email_id");
                        String mobile = obj.getString("mobile");
                        String address = obj.getString("address");

                        arruserDetalis.add(
                                new ModelClassForRecyclerview(R.drawable.img, email_id, address, name, mobile));
                    }

                    //  Set adapter AFTER data loaded
                    adapter = new RecyclerContectAdopter(Admin_activity.this, arruserDetalis);
                    admainRecyclerview.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}