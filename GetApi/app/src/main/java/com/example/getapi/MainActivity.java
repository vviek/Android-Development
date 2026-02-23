package com.example.getapi;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1
        String url = "https://jsonplaceholder.typicode.com/posts";

        ArrayList<String>  arrayList = new ArrayList<>();
        ListView listView ;
        listView=findViewById(R.id.listview);

        //2
        AndroidNetworking.initialize(MainActivity.this);
        // option get or post accouding to which api is it
        AndroidNetworking.get(url)
                .setPriority(Priority.HIGH)
                .build()
        // check in jsonviewer first bracket if this=[] then use .getAsJsonArray,if thid {} use .getAsjsonobject
                .getAsJSONArray(new JSONArrayRequestListener() {  // onject of arrylistner
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        Log.d("res",jsonArray.toString());

                        //parsing..
                        try {

                            for(int i=0;i<jsonArray.length();i++){
                            JSONObject objresutl = jsonArray.getJSONObject(i);
                            String titles =  objresutl.getString("title");

                            arrayList.add(titles);

                            }

                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,arrayList);
                            listView.setAdapter(arrayAdapter);

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("error",anError.toString());

                    }
                });  // onject of arrylistner










    }
}