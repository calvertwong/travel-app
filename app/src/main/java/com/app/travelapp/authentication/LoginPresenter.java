package com.app.travelapp.authentication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.app.travelapp.network.ApiInstance;
import com.app.travelapp.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter{
    private LoginContract.View view;
    private final String TAG = LoginPresenter.class.getSimpleName();
    Context context;


    LoginPresenter(LoginContract.View view) {
        this.view = view;
    }





    @Override
    public void buttonClick(TextInputLayout login_mobile_til, TextInputLayout login_password_til) {
        String mobile  = login_mobile_til.getEditText().toString();
        String password  = login_password_til.getEditText().toString();

        if (TextUtils.isEmpty(mobile)){
            //Toast.makeText(context, "please write your mobile", Toast.LENGTH_SHORT).show();
            view.showInputError(login_mobile_til,"input your mobile");
        }else if (TextUtils.isEmpty(password)){
           // Toast.makeText(context, "please write your password", Toast.LENGTH_SHORT).show();
            view.showInputError(login_password_til,"input your mobile");
        }else {
            ApiInstance apiIterface = RetrofitInstance.getRetrofitInstance().create(ApiInstance.class);

            Call<List<LogResponse>> call = apiIterface.setUserData(mobile,password);

            call.enqueue(new Callback<List<LogResponse>>() {
                @Override
                public void onResponse(Call<List<LogResponse>> call, Response<List<LogResponse>> response) {


                    for (int i = 0; i <response.body().size(); i++) {
                        String msg = response.body().get(i).getMsg();
                        if (msg.equals("success")){

                            String userid = response.body().get(i).getUserid();
                            String lastname = response.body().get(i).getLastname();
                            String firstname = response.body().get(i).getFirstname();
                            String email = response.body().get(i).getEmail();
                            String mobilephone = response.body().get(i).getMobile();
                            String apikey = response.body().get(i).getAppapikey();

                            Log.e(TAG, "onResponse: "+response.body().get(i).getAppapikey());

                            //SharedPreferences sharedPreferences = context.getSharedPreferences("userPre",);
                            SharedPreferences sharedPreferences = context.getSharedPreferences("userPre", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("id",userid);
                            editor.putString("lastname",lastname);
                            editor.putString("firstname",firstname);
                            editor.putString("email",email);
                            editor.putString("mobilephone",mobilephone);
                            editor.putString("apikey",apikey);
                            editor.commit();

                            view.loginSuccess();

                        }else {
                            view.loginInFailed();
                        }
                    }
                }
                @Override
                public void onFailure(Call<List<LogResponse>> call, Throwable t) {
                    Log.e(TAG, "onResponse: "+t.getMessage().toString());

                }
            });



        }

    }


}
