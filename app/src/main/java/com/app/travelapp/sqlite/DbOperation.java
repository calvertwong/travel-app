package com.app.travelapp.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;

import java.util.List;

public class DbOperation {
    private static final String TAG = DbOperation.class.getSimpleName();
    private SQLiteDatabase database;
    private DbHelper dbHelper;
    SharedPreferences sharedPreferences1;
    SharedPreferences sharedPreferences2;
    Context context;
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


        sharedPreferences1 = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferences2 = context.getSharedPreferences("userPre", Context.MODE_PRIVATE);
        String busNo = sharedPreferences1.getString("busId","");
        String routename = sharedPreferences1.getString("routeName","");
        String fare = sharedPreferences1.getString("fare","");
        String bordingtime = sharedPreferences1.getString("boardingtime","");
        String dropingtime = sharedPreferences1.getString("dropingtime","");
        String duration = sharedPreferences1.getString("journyduration","");

        String userid = sharedPreferences2.getString("id","");
        String mobile = sharedPreferences2.getString("mobilephone","");
        String email = sharedPreferences2.getString("email","");
        String fisrtname = sharedPreferences2.getString("firstname","");
        String lastname = sharedPreferences2.getString("lastname","");



        ContentValues values = new ContentValues();

        checkOrder.setRouteName(routename);
        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getRouteName());

        checkOrder.setBusid(Integer.parseInt(busNo));
        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getBusid());

        checkOrder.setFare(Float.parseFloat(fare));
        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getFare());

        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getCoupondiscount());

        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getServicetax());

        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getJournydate());

        checkOrder.setBoardingtime(bordingtime);
        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getBoardingtime());

        checkOrder.setDroppingtime(dropingtime);
        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getDroppingtime());

        checkOrder.setDuration(Float.parseFloat(duration));
        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getDuration());


        checkOrder.setPassengerid(Integer.parseInt(userid));
        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getPassengerid());

        checkOrder.setPassengeremail(email);
        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getPassengeremail());

        checkOrder.setPassengermobile(Integer.parseInt(mobile));
        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getPassengermobile());

        values.put(DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME,checkOrder.getSelectedseat());

        checkOrder.setPassengername(fisrtname+"  "+lastname);
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
        String boardingtime = cursor.getString(boardingtimeColIndex);
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
