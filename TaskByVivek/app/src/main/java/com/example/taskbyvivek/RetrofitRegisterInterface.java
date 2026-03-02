package com.example.taskbyvivek;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitRegisterInterface {


   /* @FormUrlEncoded
    @Headers("Content-Type: application/json")
    @POST("register.php")
    Call<String> registerUser(
            @Field("name") String name,
            @Field("email_id") String email,
            @Field("password") String password,
            @Field("username") String username,
            @Field("is_admin") int isAdmin,
            @Field("date_of_birth") String dob,
            @Field("mobile") String mobile,
            @Field("address") String address
    );*/


    @Headers("Content-Type: application/json")
    @POST("register.php")
    Call<String> registerNewUser(@Body RequestBody body);
}