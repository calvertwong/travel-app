package com.app.travelapp.ui;

import android.content.Context;

import com.app.travelapp.authentication.GetSeatsContract;
import com.app.travelapp.authentication.LoginContract;
import com.app.travelapp.data.DataRepository;
import com.app.travelapp.data.DataSource;
import com.app.travelapp.data.local.SeatInformationItem;
import com.app.travelapp.network.ApiInterface;
import com.app.travelapp.network.RetrofitInstance;

import java.util.List;

public class ShowBusDetailsPresenter implements GetSeatsContract.Presenter, DataSource.GetSeatCallBack {

    private static final String TAG = ShowBusDetailsPresenter.class.getSimpleName();
    private final GetSeatsContract.View view;
    private final ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
    private DataSource dataSource;
    Context context;


    public ShowBusDetailsPresenter(GetSeatsContract.View view, Context context) {

        this.view = view;
        this.context = context;
        //dataSource = new DataRepository();
    }

    @Override
    public void getSeatDetails() {
        dataSource = new DataRepository(context);
        dataSource.getSeat(this);


    }

    @Override
    public void onSeatLoad(List<SeatInformationItem> seatResponse) {

    }
}
