package com.app.travelapp.data.source.remote;

import android.annotation.SuppressLint;
import android.util.Log;
import com.app.travelapp.data.RouteIdDataSource;
import com.app.travelapp.model.RouteResponse;
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
    public void getRoute(RouteIdDataSource.GetRouteCallback routeCallback) {
        this.routeCallback = routeCallback;

        ///remove hardcoded latlong values
        ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
        Observable<RouteResponse> routeObservable = apiInterface.getRoute("41.914196",
                                                                            "-88.308685",
                                                                            "40.73061",
                                                                            "-73.935242");
        routeObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResult,this::handleError);

    }



    private void handleResult(RouteResponse routeResponse) {
        Log.e(TAG,"Route response success---" + routeResponse.toString());

        //5
        routeCallback.onRoutedLoaded(routeResponse);

    }

    private void handleError(Throwable throwable) {
        Log.e(TAG,"Route response Error---" + throwable.getMessage());
    }




}
