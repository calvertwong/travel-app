package com.app.travelapp.data;

import com.app.travelapp.data.model.CityResponse;

public interface DataSource {
    interface GetCityCallback{
        void onCityLoaded(CityResponse cityResponse);
    }

    void getCity(GetCityCallback callback);
}
