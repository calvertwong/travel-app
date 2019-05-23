package com.app.travelapp.route.citylist;

import com.app.travelapp.data.DataSource;
import com.app.travelapp.data.model.CityItem;

import java.util.List;

public interface CityListContract {
    interface View{
        void setupCityListRV(List<CityItem> cityItems);
    }

    interface Presenter{
        void getCityFromSource(DataSource data_source);
    }
}
