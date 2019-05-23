package com.app.travelapp.authentication.register;

import android.support.design.widget.TextInputLayout;

public interface RegisterContract {

    interface View{
        void displayInputError(TextInputLayout textInputLayout, String errorMsg);

        void removeInputError(TextInputLayout textInputLayout);

        void navigateToLogin(String msg);
    }

    interface Presenter{
        void validateSingleRegisterInput(TextInputLayout textInputLayout, String nameOfInput);

        void validateRegisterInputs(TextInputLayout registerFirstName, TextInputLayout registerLastName, TextInputLayout registerAddress, TextInputLayout registerEmail, TextInputLayout registerMobile, TextInputLayout registerPassword);

        void onLoginHereClick();
    }
}
