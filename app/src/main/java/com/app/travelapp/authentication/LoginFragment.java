package com.app.travelapp.authentication;


import android.content.Context;
import android.os.Bundle;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.app.travelapp.R;

import io.reactivex.internal.operators.completable.CompletableNever;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener,LoginContract.View {
    private static final String TAG = LoginFragment.class.getSimpleName();
    private TextInputLayout login_mobile_til;
    private TextInputLayout login_password_til;

    private TextInputEditText editmobile;
    private TextInputEditText editpassword;
    Context context;
    private LoginContract.Presenter loginPresenter;

    private MaterialButton sign_in;
    private TextView forgotPassword;
    private TextView noAccount;


    public LoginFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        editmobile = view.findViewById(R.id.login_mobile_tiet);
        editpassword = view.findViewById(R.id.login_password_tiet);
        login_mobile_til = view.findViewById(R.id.login_mobile_til);
        login_password_til = view.findViewById(R.id.login_password_til);
        sign_in = view.findViewById(R.id.login_sign_in_btn);
        forgotPassword = view.findViewById(R.id.login_forgot_password_r_tv);
        noAccount = view.findViewById(R.id.login_no_account_tv);
        loginPresenter = new LoginPresenter(this);

        forgotPassword.setOnClickListener(this);
        noAccount.setOnClickListener(this);

        sign_in.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //login();
                loginPresenter.buttonClick(login_mobile_til,login_password_til);
            }
        });

        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_forgot_password_r_tv:
//                ForgotPasswordFragment forgotPasswordFragment = new ForgotPasswordFragment;
//                getFragmentManager().beginTransaction().replace(R.id.fragment_container,forgotPasswordFragment);
                break;
            case R.id.login_no_account_tv:
                RegisterFragment registerFragment = new RegisterFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,registerFragment);

                break;
        }
    }



    @Override
    public void showInputError(TextInputLayout textInputLayout, String error) {
        textInputLayout.setErrorEnabled(true);
        textInputLayout.setError(error);

    }


    @Override
    public void loginSuccess() {

        Toast.makeText(context, "login Success ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginInFailed() {
        Toast.makeText(context, "login failed", Toast.LENGTH_SHORT).show();

    }
}

