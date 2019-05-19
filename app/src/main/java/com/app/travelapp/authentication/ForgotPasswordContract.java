package com.app.travelapp.authentication;

import com.google.android.material.textfield.TextInputLayout;

public interface ForgotPasswordContract {

    interface View{

        void showInputError(TextInputLayout textInputLayout, String error);

        void proceedToLoginPage();

    }

    interface Presenter{

        void buttonClicked(TextInputLayout forgot_password_email_til);
    }
}
