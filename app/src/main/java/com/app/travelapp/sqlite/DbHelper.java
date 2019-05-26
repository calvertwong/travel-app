package com.app.travelapp.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "travelapp.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TEXT_TYPE = " TEXT,";
    private static final String INTEGER_TYPE = " INTEGER,";
    private static final String FLOAT_TYPE = " REAL,";


    private static final String CREATE_TABLE_CHECK = "CREATE TABLE "
            + DbContract.DbAttribute.CHECK_TABLE_NAME + " ("
            + DbContract.DbAttribute._ID + "INTEGER PRIMARY KEY,"

            + DbContract.DbAttribute.COLUMN_NAME_CHECK_ROUTE_NAME + TEXT_TYPE
            + DbContract.DbAttribute.COLUMN_NAME_CHECK_BUS_ID + INTEGER_TYPE
            + DbContract.DbAttribute.COLUMN_NAME_CHECK_FARE + FLOAT_TYPE
            + DbContract.DbAttribute.COLUMN_NAME_CHECK_COUPONDISCOUNT + FLOAT_TYPE
            + DbContract.DbAttribute.COLUMN_NAME_CHECK_SERVICE_TAX + FLOAT_TYPE
            + DbContract.DbAttribute.COLUMN_NAME_CHECK_JOURNY_DATE + TEXT_TYPE

            + DbContract.DbAttribute.COLUMN_NAME_CHECK_BOARDING_TIME + TEXT_TYPE
            + DbContract.DbAttribute.COLUMN_NAME_CHECK_DROPING_TIME + TEXT_TYPE
            + DbContract.DbAttribute.COLUMN_NAME_CHECK_DURATION + FLOAT_TYPE
            + DbContract.DbAttribute.COLUMN_NAME_CHECK_PASSENGER_ID + INTEGER_TYPE
            + DbContract.DbAttribute.COLUMN_NAME_CHECK_PASSENFER_EMAIL + TEXT_TYPE

            + DbContract.DbAttribute.COLUMN_NAME_CHECK_PASSENFER_MOBILE + INTEGER_TYPE
            + DbContract.DbAttribute.COLUMN_NAME_CHECK_SELECTED_SET + INTEGER_TYPE
            + DbContract.DbAttribute.COLUMN_NAME_CHECK_PASSENGER_NAME + TEXT_TYPE
            + DbContract.DbAttribute.COLUMN_NAME_CHECK_PASSENGER_AGE + INTEGER_TYPE
            + DbContract.DbAttribute.COLUMN_NAME_CHECK_PASSENGER_GENDER + " TEXT" + ")";


    public DbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CHECK);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
