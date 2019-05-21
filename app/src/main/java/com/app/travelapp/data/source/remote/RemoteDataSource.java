package com.app.travelapp.data.source.remote;

import android.annotation.SuppressLint;
import android.util.Log;
import com.app.travelapp.data.DataSource;
import com.app.travelapp.model.RouteResponse;
import com.app.travelapp.network.ApiInterface;
import com.app.travelapp.network.RetrofitInstance;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RemoteDataSource implements DataSource {
    private static final String TAG = RemoteDataSource.class.getSimpleName();
    private GetRouteCallback routeCallback;


    public RemoteDataSource() {
    }

    //4
    @SuppressLint("CheckResult")
    @Override
    public void getRoute(GetRouteCallback routeCallback) {
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
