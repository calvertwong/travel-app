package com.app.travelapp.network;

import com.app.travelapp.data.local.SeatsResponse;
import com.app.travelapp.model.LogResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("login.php?")
    Call<List<LogResponse>> setUserData(
            @Field("mobile") String mobile,
            @Field("password") String password);

    //get seat
    @GET("seatinfo.php?")
    Observable<SeatsResponse> getSeat(@Query("busid") String busid);

}
