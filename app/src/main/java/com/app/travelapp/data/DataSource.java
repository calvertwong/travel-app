package com.app.travelapp.data;

import com.app.travelapp.data.local.SeatInformationItem;
import com.app.travelapp.data.local.SeatItem;

import java.util.List;

public interface DataSource {



    interface GetSeatCallBack{
        void onSeatLoad(List<SeatInformationItem> seatResponse);
    }

        void getSeat(GetSeatCallBack callBack);


}
