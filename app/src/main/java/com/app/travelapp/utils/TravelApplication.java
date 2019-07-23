package com.app.travelapp.utils;

import android.app.Application;

import com.app.travelapp.di.DaggerInjectionComponent;
import com.app.travelapp.di.InjectionComponent;
import com.app.travelapp.di.RetrofitModule;

public class TravelApplication extends Application {
    private InjectionComponent injectionComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        injectionComponent = DaggerInjectionComponent.builder()
                .retrofitModule(new RetrofitModule("https://rjtmobile.com/aamir/otr/android-app/"))
                .build();
    }

    public InjectionComponent getInjectionComponent(){
        return injectionComponent;
    }
}
