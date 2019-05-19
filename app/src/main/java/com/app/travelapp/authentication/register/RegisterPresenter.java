package com.app.travelapp.authentication.register;

import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.Log;

import com.app.travelapp.data.model.RegisterResponse;
import com.app.travelapp.data.model.RegisterUser;
import com.app.travelapp.network.ApiInstance;
import com.app.travelapp.network.RetrofitInstance;

import org.reactivestreams.Subscriber;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Register presenter
 */
public class RegisterPresenter implements RegisterContract.Presenter {
    private static final String TAG = RegisterPresenter.class.getSimpleName();
    private RegisterContract.View view;
    private ApiInstance apiInstance = RetrofitInstance.getRetrofitInstance().create(ApiInstance.class);

    // constructor
    RegisterPresenter(RegisterContract.View view) {
        this.view = view;
    }

    // triggered on lose focus and check for empty input
    @Override
    public void validateSingleRegisterInput(TextInputLayout textInputLayout, String nameOfInput) {
        if (TextUtils.isEmpty(textInputLayout.getEditText().getText())) {
            view.displayInputError(textInputLayout, "Please enter " + nameOfInput);
            Log.d(TAG, "validateSingleRegisterInput: " + nameOfInput);
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
        } else if (mobile.length() == 10) {
            view.displayInputError(registerMobile, "Please enter valid mobile");
        } else {
            Observable<RegisterResponse> registerObservable = apiInstance.registerUser(first_name, last_name, address, email, mobile, password);
            registerObservable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::handleResult, this::handleError);
            view.navigateToLogin();
        }
    }

    private void handleResult(RegisterResponse response) {
        Log.d(TAG, "handleResult: " + response);
        Log.d(TAG, "validateRegisterInputs: Success register");
    }

    private void handleError(Throwable throwable) {
        Log.d(TAG, "handleError: " +  throwable.getMessage());
    }

    @Override
    public void onLoginHereClick() {
        view.navigateToLogin();
    }
}
