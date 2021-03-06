package com.app.travelapp.data.source.remote;

import android.util.Log;

import com.app.travelapp.data.SeatSource;
import com.app.travelapp.data.model.SeatsResponse;
import com.app.travelapp.network.ApiInterface;
import com.app.travelapp.network.RetrofitInstance;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SeatRemoteDataSource implements SeatSource {
    private static final String TAG = SeatRemoteDataSource.class.getSimpleName();
    private GetSeatCallBack getSeatCallBack;


    public SeatRemoteDataSource() {

    }


    @Override
    public void getSeat(GetSeatCallBack callBack, String busId) {
        getSeatCallBack = callBack;

        ApiInterface apiInterface = RetrofitInstance
                .getRetrofitInstance()
                .create(ApiInterface.class);

        Log.d(TAG, "getSeat: " + busId);

        Observable<SeatsResponse> seatsResponseObservable = apiInterface.getSeat(busId);
        seatsResponseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResult, this::handleError);

    }

    private void handleResult(SeatsResponse seatsResponse) {
        Log.d(TAG, "handleResult: " + seatsResponse);
        getSeatCallBack.onSeatLoad(seatsResponse.getSeatinformation());
    }

    private void handleError(Throwable throwable) {
        getSeatCallBack.onSeatLoad(null);
        Log.e(TAG, "handleError: " + throwable.getMessage());
    }
}
