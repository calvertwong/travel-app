package com.app.travelapp.authentication.forgotpassword;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

public class ForgotPasswordFragment extends Fragment implements ForgotPasswordContract.View,View.OnClickListener {

    private final static String TAG = ForgotPasswordFragment.class.getSimpleName();

    private View view;
    private ForgotPasswordContract.Presenter forgot_password_presenter;
    private TextInputLayout forgot_password_email_til;
    private TextInputEditText forgot_password_email_tiet;
    private MaterialButton forgot_password_submit_btn;
    private TextView tv_toolbar_title;

    public ForgotPasswordFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_forgot_password, container, false);

        init();
        forgot_password_submit_btn.setOnClickListener(this);
        
        return view;
    }

    @SuppressLint("SetTextI18n")
    private void init() {
        forgot_password_email_tiet = view.findViewById(R.id.forgot_password_email_tiet);
        forgot_password_email_til = view.findViewById(R.id.forgot_password_email_til);
        forgot_password_submit_btn = view.findViewById(R.id.forgot_password_submit_btn);
        tv_toolbar_title = getActivity().findViewById(R.id.toolbar_title_tv);
        tv_toolbar_title.setText("Forgot Password");
        forgot_password_presenter = new ForgotPasswordPresenter(this);
    }


    @Override
    public void onClick(View v) {
        forgot_password_presenter.buttonClicked(forgot_password_email_til);

    }

    @Override
    public void showInputError(TextInputLayout textInputLayout, String error) {
        textInputLayout.setErrorEnabled(true);
        textInputLayout.setError(error);
    }

    @Override
    public void proceedToLoginPage() {
        //getFragmentManager().beginTransaction().replace(R.id.fragment_container,new LoginFragment()).commit();
        Toast.makeText(getContext(), "Redirecting to Login page", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void emailNotRegistered() {
        Toast.makeText(getContext(), "Email id is not registered", Toast.LENGTH_SHORT).show();
    }

}

