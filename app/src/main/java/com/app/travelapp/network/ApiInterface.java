package com.app.travelapp.network;


import com.app.travelapp.model.ForgotPasswordResponse;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("forgot_pass.php?")
    //Call <List<ForgotPasswordResponse>> getPassword(@Query("mobile") String mobile);
    Observable<List<ForgotPasswordResponse>> getPassword(@Query("mobile") String mobile);


}
