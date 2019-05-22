package com.app.travelapp.route.home;

import android.content.Context;
import android.util.Log;

public class HomePresenter implements HomeContract.Presenter{
    private static final String TAG = HomePresenter.class.getSimpleName();

    private HomeContract.View view;
    private Context context;

    public HomePresenter() {
    }

    public HomePresenter(HomeContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }


    @Override
    public void receiveOriginDestinationFromCityListRecyclerView(String caller, String city_name) {
        Log.d(TAG, "receiveOriginDestinationFromCityListRecyclerView: " + caller + "-----" + city_name);
    }
}
