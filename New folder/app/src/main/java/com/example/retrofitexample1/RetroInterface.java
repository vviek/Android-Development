package com.example.retrofitexample1;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetroInterface {


    @GET("json/Employee-List")
    Call<String> getData();
}
