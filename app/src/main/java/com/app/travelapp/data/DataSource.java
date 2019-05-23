package com.app.travelapp.data;

import com.app.travelapp.data.local.SeatInformationItem;
import com.app.travelapp.data.local.SeatItem;
import com.app.travelapp.data.model.CityItem;

import java.util.List;

public interface DataSource {
    interface GetCityCallback{
        void onCityLoaded(List<CityItem> cityResponse);
    }

    void getCity(GetCityCallback callback);



    interface GetSeatCallBack{
        void onSeatLoad(List<SeatInformationItem> seatResponse);
    }

        void getSeat(GetSeatCallBack callBack);


}
