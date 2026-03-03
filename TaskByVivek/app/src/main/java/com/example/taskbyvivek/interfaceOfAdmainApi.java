package com.example.taskbyvivek;

import retrofit2.Call;
import retrofit2.http.GET;

public interface interfaceOfAdmainApi {

    @GET("users.php")
    Call<String> getdata();
}
