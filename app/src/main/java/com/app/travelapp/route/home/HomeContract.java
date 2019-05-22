package com.app.travelapp.route.home;

public interface HomeContract {
    interface View{
    }

    interface Presenter{

        void receiveOriginDestinationFromCityListRecyclerView(String caller, String city_name);
    }
}
