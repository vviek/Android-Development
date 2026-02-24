package com.example.ritrofitintro;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {


    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.text1);



//https://portal.cheetahforce.com/json/get-designation
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://portal.cheetahforce.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();


        ApiInterface api =
                retrofit.create(ApiInterface.class);


        Call<String> call =
                api.getData();


        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                String data = response.body();


                try {
                    JSONObject obj = new JSONObject(data);
                    JSONArray jsonArray =obj.getJSONArray("Android");
                    JSONObject First = jsonArray.getJSONObject(0);
                   String name =  First.getString("name");

                    text1.setText(name);



                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }


            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("ERROR", t.toString());
            }
        });





    }
}