package com.app.travelapp.data;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.app.travelapp.data.source.remote.RemoteDataSource;

public class DataRepository implements DataSource {
    private DataSource remoteDataSource;
    private boolean isNetAvailable;
    private static final String TAG = DataRepository.class.getSimpleName();

    public DataRepository(Context context){

        //internet connectivity check
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        isNetAvailable = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        //get route from API
        remoteDataSource = new RemoteDataSource();
    }
    //2
    @Override
    public void getRoute(GetRouteCallback routeCallback) {
        if(isNetAvailable){
            remoteDataSource.getRoute(routeCallback);
            Log.d(TAG, "get route --" + routeCallback.toString());
        }else{
            Log.d(TAG, "get route-- " + "No Internet Connection");
        }

    }

}
