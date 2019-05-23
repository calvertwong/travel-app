package com.app.travelapp.authentication.forgotpassword;

import android.support.design.widget.TextInputLayout;

public interface ForgotPasswordContract {
    interface View{

        void showInputError(TextInputLayout textInputLayout, String error);

        void proceedToLoginPage();

        void emailNotRegistered();

    }

    interface Presenter{

        void buttonClicked(TextInputLayout forgot_password_email_til);
    }
}
