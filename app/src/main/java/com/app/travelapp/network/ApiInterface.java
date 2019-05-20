package com.app.travelapp.network;

import com.app.travelapp.data.model.CityResponse;
import com.app.travelapp.data.model.RegisterResponse;
//import com.app.travelapp.data.model.RegisterUser;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    //@Field works with POST
    //@FormUrlEncoded
    @FormUrlEncoded
    @POST("registration.php?")
    Observable<RegisterResponse> registerUser(@Field("firstname") String firstName, @Field("lastname") String lastname, @Field("address") String address, @Field("email") String email, @Field("mobile") String mobile, @Field("password") String password);

    // get city response
    @GET("city.php?")
    Observable<CityResponse> getCity();
}
