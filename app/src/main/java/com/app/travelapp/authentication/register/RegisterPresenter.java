package com.app.travelapp.authentication.register;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.Log;

import com.app.travelapp.data.DataRepository;
import com.app.travelapp.data.DataSource;
import com.app.travelapp.data.model.CityItem;
import com.app.travelapp.network.ApiInterface;
import com.app.travelapp.network.RetrofitInstance;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Register presenter
 */
public class RegisterPresenter implements RegisterContract.Presenter, DataSource.GetCityCallback {
    private static final String TAG = RegisterPresenter.class.getSimpleName();
    private final RegisterContract.View view;
    private final ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
    private final DataSource dataSource;

    // constructor
    RegisterPresenter(RegisterContract.View view, Context context) {
        this.view = view;
        dataSource = new DataRepository(context);
    }

    // triggered on lose focus and check for empty input
    @Override
    public void validateSingleRegisterInput(TextInputLayout textInputLayout, String nameOfInput) {
        if (TextUtils.isEmpty(textInputLayout.getEditText().getText())) {
            view.displayInputError(textInputLayout, "Please enter " + nameOfInput);
        } else {
            view.removeInputError(textInputLayout);
        }
    }

    // validate all inputs to register user
    // check for empty inputs
    // check for valid email
    // check for valid phone
    @Override
    public void validateRegisterInputs(TextInputLayout registerFirstName, TextInputLayout registerLastName, TextInputLayout registerAddress, TextInputLayout registerEmail, TextInputLayout registerMobile, TextInputLayout registerPassword) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        String first_name = registerFirstName.getEditText().getText().toString();
        String last_name = registerLastName.getEditText().getText().toString();
        String address = registerAddress.getEditText().getText().toString();
        String email = registerEmail.getEditText().getText().toString();
        String mobile = registerMobile.getEditText().getText().toString();
        String password = registerPassword.getEditText().getText().toString();

        if (TextUtils.isEmpty(first_name)) {
            view.displayInputError(registerFirstName, "Please enter first name");
        } else if (TextUtils.isEmpty(last_name)) {
            view.displayInputError(registerLastName, "Please enter last name");
        } else if (TextUtils.isEmpty(address)) {
            view.displayInputError(registerAddress, "Please enter address");
        } else if (TextUtils.isEmpty(email)) {
            view.displayInputError(registerEmail, "Please enter email");
        } else if (TextUtils.isEmpty(mobile)) {
            view.displayInputError(registerMobile, "Please enter mobile");
        } else if (TextUtils.isEmpty(password)) {
            view.displayInputError(registerPassword, "Please enter password");
        } else if (!email.matches(emailPattern)) {
            view.displayInputError(registerEmail, "Please enter a valid email");
        } else if (mobile.length() != 10) {
            view.displayInputError(registerMobile, "Please enter valid mobile");
        } else {
            Observable<String> registerObservable = apiInterface.registerUser(first_name, last_name, address, email, mobile, password);
            registerObservable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::handleResult, this::handleError);
        }
    }


    private void handleResult(String response) {
        Log.d(TAG, "handleRegisterResult: " + response);
        view.navigateToLogin("Register success");
    }

    private void handleError(Throwable throwable) {
        Log.d(TAG, "handleRegisterError: " +  throwable.getMessage());
    }

    // This method is supposed to navigate register to login.
    // Right now it is for testing mvp presenter and data by getting city
    @Override
    public void onLoginHereClick() {
        view.navigateToLogin("");
    }

    @Override
    public void onCityLoaded(List<CityItem> cityResponse) {
        Log.d(TAG, "onCityLoaded: " + cityResponse);
    }
}
