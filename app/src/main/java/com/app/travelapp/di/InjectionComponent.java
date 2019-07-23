package com.app.travelapp.di;

import android.content.Context;

import com.app.travelapp.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RetrofitModule.class})
public interface InjectionComponent {
    void injectRetrofit(MainActivity activity);
}
