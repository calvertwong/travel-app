package com.app.travelapp.network;

import com.app.travelapp.authentication.LogResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInstance {
    @FormUrlEncoded
    @POST("login.php?")
    Call<List<LogResponse>> setUserData(
            @Field("mobile") String mobile,
            @Field("password") String password);

}
