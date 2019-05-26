package com.app.travelapp.seat;

import android.content.Context;
import com.app.travelapp.data.SeatRepository;
import com.app.travelapp.data.SeatSource;
import com.app.travelapp.data.model.SeatInformationItem;
import com.app.travelapp.network.ApiInterface;
import com.app.travelapp.network.RetrofitInstance;

import java.util.List;

public class ShowSeatDetailsPresenter implements GetSeatsContract.Presenter, SeatSource.GetSeatCallBack {

    private static final String TAG = ShowSeatDetailsPresenter.class.getSimpleName();
    private final GetSeatsContract.View view;
    private final ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
    private SeatSource seatSource;
    Context context;


    public ShowSeatDetailsPresenter(GetSeatsContract.View view, Context context) {

        this.view = view;
        this.context = context;
        //dataSource = new DataRepository();
    }

    @Override
    public void getSeatDetails() {
        seatSource = new SeatRepository(context);
        seatSource.getSeat(this);


    }

    @Override
    public void onSeatLoad(List<SeatInformationItem> seatResponse) {

    }
}
