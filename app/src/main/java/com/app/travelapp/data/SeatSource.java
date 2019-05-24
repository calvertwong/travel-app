package com.app.travelapp.data;

import com.app.travelapp.data.model.SeatInformationItem;

import java.util.List;

public interface SeatSource {

    interface GetSeatCallBack{
        void onSeatLoad(List<SeatInformationItem> seatResponse);
    }

    void getSeat(GetSeatCallBack callBack);

}
