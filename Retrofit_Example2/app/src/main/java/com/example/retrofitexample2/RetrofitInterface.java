package com.example.retrofitexample2;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {
    @GET("json/get-Sites?empId=37")
    Call<String> getdata();
}

