package com.app.travelapp.data;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.app.travelapp.data.source.remote.CityRemoteDataSource;
import com.app.travelapp.data.source.remote.SeatRemoteDataSource;

public class SeatRepository implements SeatSource {
    private SeatSource remoteSeatDataSource;
    private boolean isNetAvailable;
    private static final String TAG = SeatRepository.class.getSimpleName();

    @Override
    public void getSeat(SeatSource.GetSeatCallBack callBack) {
        if (isNetAvailable) {
            remoteSeatDataSource.getSeat(callBack);
            Log.d(TAG, "get seat --" + callBack.toString());
        } else {
            Log.d(TAG, "get seat-- " + "No Internet Connection");
        }


    }


    public SeatRepository(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        assert cm != null;
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        isNetAvailable = activeNetwork != null && activeNetwork.isConnectedOrConnecting();


        remoteSeatDataSource = (SeatSource) new SeatRemoteDataSource();
        // get city data from API

    }

}
