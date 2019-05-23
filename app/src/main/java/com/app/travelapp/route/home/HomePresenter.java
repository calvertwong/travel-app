package com.app.travelapp.route.home;

public class HomePresenter implements HomeContract.Presenter{
    private static final String TAG = HomePresenter.class.getSimpleName();
    private HomeContract.View view;


    public HomePresenter(HomeContract.View view) {
        this.view = view;
    }


}
