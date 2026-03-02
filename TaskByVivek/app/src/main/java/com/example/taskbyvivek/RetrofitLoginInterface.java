package com.example.taskbyvivek;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitLoginInterface {

    @Headers("Content-Type: application/json")
    @POST("login.php")
    Call<ResponseBody> postRawJson(@Body RequestBody body);


}
