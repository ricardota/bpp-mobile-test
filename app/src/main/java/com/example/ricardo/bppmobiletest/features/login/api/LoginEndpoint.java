package com.example.ricardo.bppmobiletest.features.login.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginEndpoint {

    @POST("login")
    @FormUrlEncoded
    Call<LoginPayload> login(
            @Field("email") String email,
            @Field("password") String password
    );
}
