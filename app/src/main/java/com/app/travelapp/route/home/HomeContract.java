package com.app.travelapp.route.home;

public interface HomeContract {
    interface View{
        void setOriginDestinationText(String caller, String city_name);
    }

    interface Presenter{
        void receiveOriginDestinationFromCityListRecyclerView(String caller, String city_name);
    }
}
