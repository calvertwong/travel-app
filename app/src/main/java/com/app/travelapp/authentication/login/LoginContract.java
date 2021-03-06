package com.app.travelapp.authentication.login;

import android.support.design.widget.TextInputLayout;

public interface LoginContract {
    interface View{
        void showInputError(TextInputLayout textInputLayout, String error);

        void getTohomePage();

        void loginSuccess(String msg);

        void loginInFailed(String msg);
    }

    interface Presenter{
        void loginButtonClicked(TextInputLayout login_mobile_til, TextInputLayout login_password_til);
    }

}
