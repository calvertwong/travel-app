package com.app.travelapp.authentication.login;

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
import com.app.travelapp.authentication.forgotpassword.ForgotPasswordFragment;
import com.app.travelapp.authentication.register.RegisterFragment;

public class LoginFragment extends Fragment implements View.OnClickListener, LoginContract.View {
    private static final String TAG = LoginFragment.class.getSimpleName();
    private TextInputLayout login_mobile_til;
    private TextInputLayout login_password_til;
    private TextInputEditText login_mobile_et;
    private TextInputEditText login_password_et;
    Context context;
    private LoginContract.Presenter login_presenter;
    private MaterialButton login_material_btn;
    private TextView forgt_password_tv;
    private TextView no_account_tv;
    private View view;

    public LoginFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);

        init();

        forgt_password_tv.setOnClickListener(this);
        no_account_tv.setOnClickListener(this);
        login_material_btn.setOnClickListener(this);

        return view;
    }

    private void init() {
        login_mobile_et = view.findViewById(R.id.login_mobile_tiet);
        login_password_et = view.findViewById(R.id.login_password_tiet);
        login_mobile_til = view.findViewById(R.id.login_mobile_til);
        login_password_til = view.findViewById(R.id.login_password_til);
        login_material_btn = view.findViewById(R.id.login_sign_in_btn);
        forgt_password_tv = view.findViewById(R.id.login_forgot_password_r_tv);
        no_account_tv = view.findViewById(R.id.login_no_account_tv);
        login_presenter = new LoginPresenter(this, getContext());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_forgot_password_r_tv:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ForgotPasswordFragment()).addToBackStack(null).commit();
                break;
            case R.id.login_no_account_tv:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new RegisterFragment()).addToBackStack(null).commit();
                break;
            case R.id.login_sign_in_btn:
                login_presenter.loginButtonClicked(login_mobile_til, login_password_til);
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

