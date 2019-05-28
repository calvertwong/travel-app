package com.app.travelapp.seatselection;

import android.content.Context;
import android.util.Log;

import com.app.travelapp.data.SeatRepository;
import com.app.travelapp.data.SeatSource;
import com.app.travelapp.data.model.SeatInformationItem;
import com.app.travelapp.network.ApiInterface;
import com.app.travelapp.network.RetrofitInstance;
import com.app.travelapp.seat.GetSeatsContract;

import java.util.List;

public class SeatSelectionPresenter implements com.app.travelapp.seat.GetSeatsContract.Presenter, SeatSource.GetSeatCallBack {

    private static final String TAG = com.app.travelapp.seat.ShowSeatDetailsPresenter.class.getSimpleName();
    private final SeatSelectionContract.View view;
    private final ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
    private SeatSource seatSource;
    Context context;


    public SeatSelectionPresenter(SeatSelectionContract.View view, Context context) {

        this.view = view;
        this.context = context;
        seatSource = new SeatRepository(context);
    }

    @Override
    public void getSeatDetails() {
        seatSource.getSeat(this);
    }

    @Override
    public void onSeatLoad(List<SeatInformationItem> seatResponse) {
        Log.d(TAG, "onSeatLoad: " + seatResponse);
        view.parseSeatResponse(seatResponse);
    }
}


