package com.app.travelapp.data;

import com.app.travelapp.model.RouteResponse;

public interface DataSource {
    interface GetRouteCallback{
        void onRoutedLoaded(RouteResponse routeResponse);
    }


    void getRoute(GetRouteCallback callback);

}
