package com.app.travelapp.data.source.remote;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.app.travelapp.data.BusDetailDataSource;
import com.app.travelapp.data.model.BusDetailResponse;
import com.app.travelapp.network.ApiInterface;
import com.app.travelapp.network.RetrofitInstance;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BusDetailRemoteDataSource implements BusDetailDataSource {
    private static final String TAG = BusDetailRemoteDataSource.class.getSimpleName();
   private GetBusDetailCallback callback;

   public BusDetailRemoteDataSource(){

   }

    @Override
    public void getBusDetail(GetBusDetailCallback busDetailCallback, String routeID) {

        this.callback = busDetailCallback;
        ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
        //remove the hardcoded route ID
        Observable<BusDetailResponse> busDetailObservable = apiInterface.getBusDetail(routeID);
        busDetailObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResult,this::handleError);

    }
    private void handleResult(BusDetailResponse busDetailResponse) {
        Log.e(TAG,"Response---" + busDetailResponse.toString());
        callback.onBusDetailLoaded(busDetailResponse.getBusinformation());
    }


    private void handleError(Throwable throwable) {
        Log.e(TAG,"error---" + throwable.getMessage());

    }

}
