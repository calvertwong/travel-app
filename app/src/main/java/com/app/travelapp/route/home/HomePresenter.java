package com.app.travelapp.route.home;

import android.util.Log;

public class HomePresenter implements HomeContract.Presenter{
    private static final String TAG = HomePresenter.class.getSimpleName();
    private HomeContract.View view;

    public HomePresenter() {
    }

    public HomePresenter(HomeContract.View view) {
        this.view = view;
    }


    @Override
    public void receiveOriginDestinationFromCityListRecyclerView(String caller, String city_name) {
        Log.d(TAG, "receiveOriginDestinationFromCityListRecyclerView: " + caller + "-----" + city_name);
        view.setOriginDestinationText(caller, city_name);
    }
}
