package com.app.travelapp.authentication;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;

import com.app.travelapp.model.ForgotPasswordResponse;
import com.app.travelapp.network.ApiInterface;
import com.app.travelapp.network.RetrofitInstance;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ForgotPasswordPresenter implements ForgotPasswordContract.Presenter{

    private final String TAG = ForgotPasswordPresenter.class.getSimpleName();
    private ForgotPasswordContract.View view;

    ForgotPasswordPresenter(ForgotPasswordContract.View view) {
        this.view = view;
    }


    @SuppressLint("CheckResult")
    @Override
    public void buttonClicked(TextInputLayout forgot_password_email_til) {

        String email = forgot_password_email_til.getEditText().getText().toString();

        if(TextUtils.isEmpty(email)){
            view.showInputError(forgot_password_email_til,"Please Enter Email");
        }
        else if(!(Patterns.EMAIL_ADDRESS.matcher(email).matches()));
        {
            view.showInputError(forgot_password_email_til,"Please Enter a valid Email");
        }

        ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);

        //delete the hardcoded mobile number
        Observable<List<ForgotPasswordResponse>> observable = apiInterface.getPassword("9876543210");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResult,this::handleError);
        view.proceedToLoginPage();

    }
    private void handleResult(List<ForgotPasswordResponse> response) {
        Log.e(TAG,"Response--" + response.get(0).getMsg());
        if(response.get(0).getMsg().equals("User mobile number and password"));{
            view.proceedToLoginPage();
        }
    }

    private void handleError(Throwable throwable) {
        Log.e(TAG,"error--" + throwable.getMessage());
    }
}