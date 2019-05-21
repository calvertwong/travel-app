package com.app.travelapp.network;

import com.app.travelapp.model.BusDetailResponse;
import com.app.travelapp.model.ForgotPasswordResponse;
import com.app.travelapp.model.RouteResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("forgot_pass.php?")
    Observable<List<ForgotPasswordResponse>> getPassword(@Query("mobile") String mobile);

    //get route
    @GET("routeinfo.php?")
    Observable<RouteResponse> getRoute(@Query("route-startpoint-latitude") String startPointLat,
                                       @Query("route-startpoint-longitude") String startPointLong,
                                       @Query("route-endpoint-latitude") String endPointLat,
                                       @Query("route-endpoint-longiude") String endPointLong);

    @GET("businfo.php?")
    Observable<BusDetailResponse> getBusDetail(@Query("id") String routeId);


}
