package com.app.travelapp.data;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.ContactsContract;
import android.util.Log;

import com.app.travelapp.data.remote.SeatRemoteDataSource;

public class DataRepository implements DataSource {
    private DataSource remoteDataSource;
    private boolean isNetAvailable;
    private static final String TAG = DataRepository.class.getSimpleName();


     public DataRepository(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        assert  cm != null;
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        isNetAvailable = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        remoteDataSource = (DataSource) new SeatRemoteDataSource();
    }


    @Override
    public void getSeat(GetSeatCallBack callBack) {
        if (isNetAvailable){
            remoteDataSource.getSeat(callBack);
            Log.d(TAG, "get route --" + callBack.toString());
        }else {
            Log.d(TAG, "get route-- " + "No Internet Connection");
        }



    }
}
