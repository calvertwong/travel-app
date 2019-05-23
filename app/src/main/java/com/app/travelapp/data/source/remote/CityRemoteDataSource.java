package com.app.travelapp.data.source.remote;

import android.content.Context;
import android.util.Log;

import com.app.travelapp.data.DataSource;
import com.app.travelapp.data.model.CityResponse;
import com.app.travelapp.network.ApiInterface;
import com.app.travelapp.network.RetrofitInstance;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CityRemoteDataSource implements DataSource {
    private static final String TAG = CityRemoteDataSource.class.getSimpleName();
    private GetCityCallback callback;

    public CityRemoteDataSource() {
    }

    //step 4
    //get city response using retrofit and rxjava
    @Override
    public void getCity(GetCityCallback callback) {
        this.callback = callback;
        ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
        Observable<CityResponse> cityResponseObservable = apiInterface.getCity();
        cityResponseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResult, this::handleError);
    }

    //return city response to the presenter on success
    private void handleResult(CityResponse cityResponse) {
        Log.d(TAG, "handleCityResult: " + cityResponse.getCity().get(0));
        //step 5
        callback.onCityLoaded(cityResponse.getCity());
    }

    //log error if couldn't get city data
    private void handleError(Throwable throwable) {
        Log.d(TAG, "handleCityError: " + throwable.getMessage());
    }
}
