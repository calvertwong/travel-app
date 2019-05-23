package com.app.travelapp.data;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.app.travelapp.data.source.remote.CityRemoteDataSource;

public class DataRepository implements DataSource {
    private DataSource remoteCityDataSource;
    private boolean isNetAvailable;
    private static final String TAG = DataRepository.class.getSimpleName();

    public DataRepository(Context context) {
        // check for internet connectivity
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        isNetAvailable = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        // get city data from API
        remoteCityDataSource = new CityRemoteDataSource();
    }

    // step 2
    @Override
    public void getCity(GetCityCallback callback) {
        if(isNetAvailable){
            remoteCityDataSource.getCity(callback);
            Log.d(TAG, "getCity: " + "internet");
        }else{
            Log.d(TAG, "getCity: " + "no internet");
        }
    }
}
