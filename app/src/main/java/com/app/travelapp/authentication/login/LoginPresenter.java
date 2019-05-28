package com.app.travelapp.authentication.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.app.travelapp.data.model.LoginResponse;
import com.app.travelapp.network.ApiInterface;
import com.app.travelapp.network.RetrofitInstance;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter{
    private LoginContract.View view;
    private final String TAG = LoginPresenter.class.getSimpleName();
    private Context context;

    LoginPresenter(LoginContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void loginButtonClicked(TextInputLayout login_mobile_til, TextInputLayout login_password_til) {
        String mobile  = login_mobile_til.getEditText().getText().toString();
        String password  = login_password_til.getEditText().getText().toString();

        if (TextUtils.isEmpty(mobile)){
            view.showInputError(login_mobile_til,"Enter your mobile");
        }else if (TextUtils.isEmpty(password)){
            view.showInputError(login_password_til,"Enter your password");
        }else {
            ApiInterface apiIterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);


            Observable<List<LoginResponse>> loginObservable = apiIterface.setUserData(mobile,password);
            loginObservable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::handleResult, this::handleError);

            view.getTohomePage();

        }

    }

    private void handleError(Throwable throwable) {
        Log.e(TAG, "handleLoginError: " +  throwable.getMessage());

        view.loginInFailed("login failed");

    }

    private void handleResult(List<LoginResponse> loginResponses) {
        for (int i = 0; i <loginResponses.size() ; i++) {
             String userid = loginResponses.get(i).getUserid();
             String lastname = loginResponses.get(i).getLastname();
             String firstname = loginResponses.get(i).getFirstname();
             String email = loginResponses.get(i).getEmail();
             String mobilephone = loginResponses.get(i).getMobile();
             String apikey = loginResponses.get(i).getAppapikey();
             Log.e(TAG, "handleLoginResult: " + loginResponses.get(i).getEmail());


            SharedPreferences sharedPreferences = context.getSharedPreferences("userPre", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("id",userid);
            editor.putString("lastname",lastname);
            editor.putString("firstname",firstname);
            editor.putString("email",email);
            editor.putString("mobilephone",mobilephone);
            editor.putString("apikey",apikey);
            editor.commit();


        }

        view.loginSuccess("login success");

    }
}
