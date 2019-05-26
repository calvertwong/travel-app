package com.app.travelapp.sqlite;

import android.provider.BaseColumns;

public class DbContract {
    static abstract class DbAttribute implements BaseColumns{
        static final String CHECK_TABLE_NAME = "checkorder";
        static final String COLUMN_NAME_CHECK_ROUTE_NAME = "route_name";
        static final String COLUMN_NAME_CHECK_BUS_ID = "busid";
        static final String COLUMN_NAME_CHECK_FARE = "fare";
        static final String COLUMN_NAME_CHECK_COUPONDISCOUNT = "coupondiscount";
        static final String COLUMN_NAME_CHECK_SERVICE_TAX = "servicetax";
        static final String COLUMN_NAME_CHECK_JOURNY_DATE = "journydate";


        static final String COLUMN_NAME_CHECK_BOARDING_TIME = "boardingtime";
        static final String COLUMN_NAME_CHECK_DROPING_TIME = "droppingtime";
        static final String COLUMN_NAME_CHECK_DURATION = "duration";
        static final String COLUMN_NAME_CHECK_PASSENGER_ID = "passengerid";
        static final String COLUMN_NAME_CHECK_PASSENFER_EMAIL = "passengeremail";
        static final String COLUMN_NAME_CHECK_PASSENFER_MOBILE = "passengermobile";

        static final String COLUMN_NAME_CHECK_SELECTED_SET = "selectedseat";
        static final String COLUMN_NAME_CHECK_PASSENGER_NAME = "passengername";
        static final String COLUMN_NAME_CHECK_PASSENGER_AGE = "passengerage";
        static final String COLUMN_NAME_CHECK_PASSENGER_GENDER = "passengergender";
    }
}
