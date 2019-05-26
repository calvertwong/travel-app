package com.app.travelapp.data;

import com.app.travelapp.data.model.RouteResponse;

public interface RouteIdDataSource {
    interface GetRouteCallback {

        void onRoutedLoaded(RouteResponse routeResponse);
    }
    void getRoute(GetRouteCallback callback, String startLat, String startLong, String endLat, String endLong);
}
