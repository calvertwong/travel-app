package com.app.travelapp.data;
import com.app.travelapp.data.model.BusDetailResponse;
import com.app.travelapp.data.model.BusInformationItem;

import java.util.List;


public interface BusDetailDataSource {
    interface GetBusDetailCallback {
        //void onBusDetailLoaded(List<BusInformationItem> busInformationItems);
        void onBusDetailLoaded(List<BusInformationItem> busDetailResponse);
    }
        void getBusDetail(GetBusDetailCallback busDetailCallback);
}
