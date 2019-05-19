package com.app.travelapp.authentication;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.app.travelapp.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ForgotPasswordFragment extends Fragment implements ForgotPasswordContract.View, View.OnClickListener {

    private final static String TAG = ForgotPasswordFragment.class.getSimpleName();
    private View view;
    private ForgotPasswordContract.Presenter forgot_password_presenter;
    private TextInputLayout forgot_password_email_til;
    private TextInputEditText forgot_password_email_tiet;
    private MaterialButton forgot_password_submit_btn;
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
    private void init(){
        forgot_password_email_tiet = view.findViewById(R.id.forgot_password_email_tiet);
        forgot_password_email_til = view.findViewById(R.id.forgot_password_email_til);
        forgot_password_submit_btn = view.findViewById(R.id.forgot_password_submit_btn);
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

    }
}
