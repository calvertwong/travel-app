package com.app.travelapp.network;

import com.app.travelapp.data.model.CityResponse;
import com.app.travelapp.data.model.RegisterResponse;
//import com.app.travelapp.data.model.RegisterUser;
import com.app.travelapp.model.ForgotPasswordResponse;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("registration.php?")
    Observable<String> registerUser(@Query("firstname") String firstName, @Query("lastname") String lastname, @Query("address") String address, @Query("email") String email, @Query("mobile") String mobile, @Query("password") String password);

    // get city response
    @GET("city.php?")
    Observable<CityResponse> getCity();

    @GET("forgot_pass.php?")
    Observable<List<ForgotPasswordResponse>> getPassword(@Query("mobile") String mobile);
}
