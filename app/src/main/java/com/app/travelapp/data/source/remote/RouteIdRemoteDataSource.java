package com.app.travelapp.data.source.remote;

import android.annotation.SuppressLint;
import android.util.Log;

import com.app.travelapp.data.RouteIdDataSource;
import com.app.travelapp.data.model.RouteResponse;
import com.app.travelapp.network.ApiInterface;
import com.app.travelapp.network.RetrofitInstance;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RouteIdRemoteDataSource implements RouteIdDataSource {
    private static final String TAG = RouteIdRemoteDataSource.class.getSimpleName();
    private RouteIdDataSource.GetRouteCallback routeCallback;


    public RouteIdRemoteDataSource() {
    }

    //4
    @SuppressLint("CheckResult")
    @Override
    public void getRoute(GetRouteCallback routeCallback, String startLat, String startLong, String endLat, String endLong) {
        this.routeCallback = routeCallback;
        Log.d(TAG, "getRoute: " + startLat);
        Log.d(TAG, "getRoute: " + startLong);
        Log.d(TAG, "getRoute: " + endLat);
        Log.d(TAG, "getRoute: " + endLong);

        ///remove hardcoded latlong values
        ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
//        Observable<RouteResponse> routeObservable = apiInterface.getRoute("41.914196",
//                                                                            "-88.308685",
//                                                                            "40.73061",
//                                                                            "-73.935242");
        Observable<RouteResponse> routeObservable = apiInterface.getRoute(startLat, startLong, endLat, endLong);

        routeObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResult, this::handleError);

    }


    private void handleResult(RouteResponse routeResponse) {
//        Log.e(TAG, "Route response success---" + routeResponse.getRoute().get(0).getId());
        Log.e(TAG, "Route response success---" + routeResponse);
        //need to store routeId into shared preference to use it for next network call

        //5
        routeCallback.onRoutedLoaded(routeResponse);
    }

    private void handleError(Throwable throwable) {
        Log.e(TAG, "Route response Error---" + throwable.getMessage());
        routeCallback.onRoutedLoaded(null);
    }


}
