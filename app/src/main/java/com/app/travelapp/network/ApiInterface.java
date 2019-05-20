package com.app.travelapp.network;

import com.app.travelapp.model.ForgotPasswordResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("forgot_pass.php?")
    Observable<List<ForgotPasswordResponse>> getPassword(@Query("mobile") String mobile);
}
