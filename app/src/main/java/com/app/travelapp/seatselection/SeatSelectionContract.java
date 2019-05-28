package com.app.travelapp.seatselection;

import com.app.travelapp.data.model.SeatInformationItem;

import java.util.List;

public interface SeatSelectionContract {

    interface View{
        void parseSeatResponse(List<SeatInformationItem> seatResponse);
    }

    interface Presenter{
        void getSeatDetails(String busId);
    }
}
