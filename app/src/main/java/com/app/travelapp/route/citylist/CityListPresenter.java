package com.app.travelapp.route.citylist;

import android.util.Log;
import android.view.View;

import com.app.travelapp.data.DataRepository;
import com.app.travelapp.data.DataSource;
import com.app.travelapp.data.model.CityItem;

import java.util.List;

public class CityListPresenter implements CityListContract.Presenter, DataRepository.GetCityCallback {
    private static final String TAG = CityListPresenter.class.getSimpleName();
    private CityListContract.View view;

    public CityListPresenter(CityListContract.View view) {
        this.view = view;
    }

    public void getCityFromSource(DataSource data_source) {
        data_source.getCity(this);
    }

    @Override
    public void onCityLoaded(List<CityItem> cityItems) {
        Log.d(TAG, "onCityLoaded: " + cityItems);
        view.setupCityListRV(cityItems);
    }
}
