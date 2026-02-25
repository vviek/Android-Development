package com.example.imagefromgetapi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetroFitInterface {
    @GET("v1/images/search?limit=3")
    Call<String> getdata();

}
