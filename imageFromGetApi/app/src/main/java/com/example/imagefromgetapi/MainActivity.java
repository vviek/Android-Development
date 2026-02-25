package com.example.imagefromgetapi;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

        ImageView image1,image2;
        image1=findViewById(R.id.image1);
        image2=findViewById(R.id.image2);





//https://api.thecatapi.com/v1/images/search?limit=3v1/images/search?limit=3
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.thecatapi.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();


        RetroFitInterface api = retrofit.create(RetroFitInterface.class);


        Call<String> call = api.getdata();


        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                String data = response.body();


                Log.d("API_DATA", data);

                try {
                    JSONArray jsonArray = new JSONArray(data);
                    for(int i=0;i<2;i++) {
                        JSONObject finaldata = jsonArray.getJSONObject(i);
                        String image = finaldata.getString("url");

                       Log.e("IMage URL",":"+image);
                        //load image
                        if(i==0) {
                            Picasso.get()
                                    .load(image)
                                    .into(image1);

                        }else {

                            Picasso.get()
                                    .load(image)
                                    .into(image2);

                        }

                    }

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