package com.app.travelapp.data;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.app.travelapp.data.source.remote.RouteIdRemoteDataSource;

public class RouteIdDataRepository implements RouteIdDataSource {
    private RouteIdDataSource remoteRouteIdDataSource;
    private boolean isNetAvailable;
    private static final String TAG = RouteIdDataRepository.class.getSimpleName();

    public RouteIdDataRepository(Context context){

        //internet connectivity check
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        isNetAvailable = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        //get route from API
        remoteRouteIdDataSource = new RouteIdRemoteDataSource();
    }
    //2
    @Override
    public void getRoute(GetRouteCallback routeCallback) {
        if(isNetAvailable){
            remoteRouteIdDataSource.getRoute(routeCallback);
            Log.d(TAG, "get route --" + routeCallback.toString());
        }else{
            Log.d(TAG, "get route-- " + "No Internet Connection");
        }

    }



}
