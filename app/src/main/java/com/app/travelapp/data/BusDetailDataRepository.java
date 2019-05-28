package com.app.travelapp.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.app.travelapp.data.source.remote.BusDetailRemoteDataSource;

public class BusDetailDataRepository implements BusDetailDataSource {
    private BusDetailDataSource remoteBusDetailDataSource;
    private boolean isNetAvailable;
    private static final String TAG = BusDetailDataRepository.class.getSimpleName();
    private SharedPreferences preferences;

    public BusDetailDataRepository(Context context){

        preferences = context.getSharedPreferences("tripDetail",Context.MODE_PRIVATE);
        //internet connectivity check
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        isNetAvailable = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        //get route from API
        remoteBusDetailDataSource = new BusDetailRemoteDataSource();

    }

    @Override
    public void getBusDetail(GetBusDetailCallback busDetailCallback, String routeID) {
        if(isNetAvailable){
            remoteBusDetailDataSource.getBusDetail(busDetailCallback, routeID);
            Log.e(TAG,"Get Bus Detail" + routeID);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("routeId", routeID);
            editor.apply();

        }
        else
            Log.e(TAG,"Get Bus Detail .. No Internet");
    }
}
