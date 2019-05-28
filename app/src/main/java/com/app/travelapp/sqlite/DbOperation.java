package com.app.travelapp.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

public class DbOperation {
    private static final String TAG = DbOperation.class.getSimpleName();
    private SQLiteDatabase database;
    private DbHelper dbHelper;
    //private List<CheckOrder> checkOrderslist;


    public DbOperation(Context context){
        dbHelper = new DbHelper(context);
    }

    public void openDb(){
        database = dbHelper.getWritableDatabase();
    }

    public void closeDb(){
        database.close();
    }

    public void createProductListRow(CheckOrder checkOrder) {
        ContentValues values = new ContentValues();
        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getRouteName());
        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getBusid());
        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getFare());
        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getCoupondiscount());

        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getServicetax());
        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getJournydate());
        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getBoardingtime());
        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getDroppingtime());

        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getDuration());
        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getPassengerid());
        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getPassengeremail());
        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getPassengermobile());

        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getSelectedseat());
        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getPassengername());
        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getPassengerage());
        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getPassengergender());

        database.insert(DbContract.DbAttribute.CHECK_TABLE_NAME,null,values);


    }

    public CheckOrder readProductListRow() {

        Cursor cursor = database.query(DbContract.DbAttribute.CHECK_TABLE_NAME,null, null, null, null, null, null);

        int routeNameColIndex = cursor.getColumnIndexOrThrow(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME);
        int busidColIndex = cursor.getColumnIndexOrThrow(DbContract.DbAttribute.COLUMN_NAME_CHECK_BUS_ID);
        int fareColIndex = cursor.getColumnIndexOrThrow(DbContract.DbAttribute.COLUMN_NAME_CHECK_FARE);
        int coupondiscountColIndex = cursor.getColumnIndexOrThrow(DbContract.DbAttribute.COLUMN_NAME_CHECK_COUPONDISCOUNT);


        int servicetaxColIndex = cursor.getColumnIndexOrThrow(DbContract.DbAttribute.COLUMN_NAME_CHECK_SERVICE_TAX);
        int journydateColIndex = cursor.getColumnIndexOrThrow(DbContract.DbAttribute.COLUMN_NAME_CHECK_JOURNY_DATE);
        int boardingtimeColIndex = cursor.getColumnIndexOrThrow(DbContract.DbAttribute.COLUMN_NAME_CHECK_BOARDING_TIME);
        int droppingtimeColIndex = cursor.getColumnIndexOrThrow(DbContract.DbAttribute.COLUMN_NAME_CHECK_DROPING_TIME);


        int durationColIndex = cursor.getColumnIndexOrThrow(DbContract.DbAttribute.COLUMN_NAME_CHECK_DURATION);
        int passengeridColIndex = cursor.getColumnIndexOrThrow(DbContract.DbAttribute.COLUMN_NAME_CHECK_PASSENGER_ID);
        int passengeremailColIndex = cursor.getColumnIndexOrThrow(DbContract.DbAttribute.COLUMN_NAME_CHECK_PASSENFER_EMAIL);
        int passengermobileColIndex = cursor.getColumnIndexOrThrow(DbContract.DbAttribute.COLUMN_NAME_CHECK_PASSENFER_MOBILE);


        int selectedseatColIndex = cursor.getColumnIndexOrThrow(DbContract.DbAttribute.COLUMN_NAME_CHECK_SELECTED_SET);
        int passengernameColIndex = cursor.getColumnIndexOrThrow(DbContract.DbAttribute.COLUMN_NAME_CHECK_PASSENGER_NAME);
        int passengerageColIndex = cursor.getColumnIndexOrThrow(DbContract.DbAttribute.COLUMN_NAME_CHECK_PASSENGER_AGE);
        int passengergenderColIndex = cursor.getColumnIndexOrThrow(DbContract.DbAttribute.COLUMN_NAME_CHECK_PASSENGER_GENDER);


        cursor.moveToFirst();

        String routeName = cursor.getString(routeNameColIndex);
        int busid = cursor.getInt(busidColIndex);
        float fare = cursor.getFloat(fareColIndex);
        float coupondiscount = cursor.getFloat(coupondiscountColIndex);
        float servicetax = cursor.getFloat(servicetaxColIndex);
        String journydate = cursor.getString(journydateColIndex);
        String boardingtime = cursor.getString(journydateColIndex);
        String droppingtime = cursor.getString(droppingtimeColIndex);
        float duration = cursor.getFloat(durationColIndex);
        int passengerid = cursor.getInt(passengeridColIndex);
        String passengeremail = cursor.getString(passengeremailColIndex);
        int passengermobile = cursor.getInt(passengermobileColIndex);
        int selectedseat = cursor.getInt(selectedseatColIndex);
        String passengername = cursor.getString(passengernameColIndex);
        int passengerage = cursor.getInt(passengerageColIndex);
        String passengergender = cursor.getString(passengergenderColIndex);

        return new CheckOrder(routeName,busid,fare,coupondiscount,servicetax,journydate,
                boardingtime,droppingtime,duration,passengerid,passengeremail,passengermobile,selectedseat,
                passengername,passengerage,passengergender);
    }



}
