package com.app.travelapp.data;

import com.app.travelapp.data.model.SeatInformationItem;
import com.app.travelapp.data.model.CityItem;

import java.util.List;

public interface DataSource {
    interface GetCityCallback{
        void onCityLoaded(List<CityItem> cityResponse);
    }

    void getCity(GetCityCallback callback);




}
