package com.app.travelapp.authentication;

import android.support.design.widget.TextInputLayout;

public class LoginContract {
    interface View{
        void showInputError(TextInputLayout textInputLayout, String error);


        void loginSuccess();

        void loginInFailed();
    }

    interface Presenter{

        void buttonClick(TextInputLayout login_mobile_til, TextInputLayout login_password_til);


    }

}
