package com.app.travelapp.data;
import com.app.travelapp.model.BusDetailResponse;
import com.app.travelapp.model.BusInformationItem;
import java.util.List;


public interface BusDetailDataSource {

    interface GetBusDetailCallback {

        //void onBusDetailLoaded(List<BusInformationItem> busInformationItems);
        void onBusDetailLoaded(BusDetailResponse busDetailResponse);
    }
        void getBusDetail(GetBusDetailCallback busDetailCallback);
}
