package com.app.travelapp.authentication.register;

import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.Log;

/**
 * Register presenter
 */
public class RegisterPresenter implements RegisterContract.Presenter {
    private static final String TAG = RegisterPresenter.class.getSimpleName();
    private RegisterContract.View view;

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

        if (TextUtils.isEmpty(registerFirstName.getEditText().getText())) {
            view.displayInputError(registerFirstName, "Please enter first name");
        } else if (TextUtils.isEmpty(registerLastName.getEditText().getText())) {
            view.displayInputError(registerLastName, "Please enter last name");
        } else if (TextUtils.isEmpty(registerAddress.getEditText().getText())) {
            view.displayInputError(registerAddress, "Please enter address");
        } else if (TextUtils.isEmpty(registerEmail.getEditText().getText())) {
            view.displayInputError(registerEmail, "Please enter email");
        } else if (TextUtils.isEmpty(registerMobile.getEditText().getText())) {
            view.displayInputError(registerMobile, "Please enter mobile");
        } else if (TextUtils.isEmpty(registerPassword.getEditText().getText())) {
            view.displayInputError(registerPassword, "Please enter password");
        } else if(!registerEmail.getEditText().getText().toString().matches(emailPattern)){
            view.displayInputError(registerEmail, "Please enter a valid email");
        }else if(registerMobile.getEditText().getText().length() == 10){
            view.displayInputError(registerMobile, "Please enter valid mobile");
        }else{
            Log.d(TAG, "validateRegisterInputs: Success register");
            view.navigateToLogin();
        }
    }

    @Override
    public void onLoginHereClick() {
        view.navigateToLogin();
    }
}
