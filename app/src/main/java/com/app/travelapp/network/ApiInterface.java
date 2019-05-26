package com.app.travelapp.network;

import com.app.travelapp.data.model.CityResponse;
import com.app.travelapp.data.model.ForgotPasswordResponse;
import com.app.travelapp.data.model.LoginResponse;

import com.app.travelapp.data.model.SeatsResponse;
import com.app.travelapp.data.model.BusDetailResponse;
import com.app.travelapp.data.model.RouteResponse;
import java.util.List;
import io.reactivex.Observable;
import retrofit2.Call;
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

        @FormUrlEncoded
        @POST("login.php?")
        Call<List<LoginResponse>> setUserData(
                @Field("mobile") String mobile,
                @Field("password") String password);

        @GET("seatinfo.php?")
        Observable<SeatsResponse> getSeat(@Query("busid") String busid);

        @GET("routeinfo.php?")
        Observable<RouteResponse> getRoute(@Query("route-startpoint-latitude") String startPointLat,
                                           @Query("route-startpoint-longitude") String startPointLong,
                                           @Query("route-endpoint-latitude") String endPointLat,
                                           @Query("route-endpoint-longiude") String endPointLong);
        //get bus detail
        @GET("businfo.php?")
        Observable<BusDetailResponse> getBusDetail(@Query("routeid") String routeId);


    }
