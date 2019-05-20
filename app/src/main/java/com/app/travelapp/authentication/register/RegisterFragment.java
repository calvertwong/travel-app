package com.app.travelapp.authentication.register;


import android.os.Bundle;
import android.support.annotation.NonNull;
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


public class RegisterFragment extends Fragment implements RegisterContract.View, View.OnClickListener, View.OnFocusChangeListener {
    private static final String TAG = RegisterFragment.class.getSimpleName();
    private View view;
    private TextView register_login_here_tv;
    private RegisterContract.Presenter register_presenter;
    private TextInputLayout register_first_name_til, register_last_name_til, register_address_til, register_email_til, register_mobile_til, register_password_til;
    private TextInputEditText register_first_name_tiet, register_last_name_tiet, register_address_tiet, register_email_tiet, register_mobile_tiet, register_password_tiet;
    private MaterialButton register_sign_up_btn;

    public RegisterFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register, container, false);

        // initialize variables
        init();

        register_sign_up_btn.setOnClickListener(this);

        register_first_name_tiet.setOnFocusChangeListener(this);
        register_last_name_tiet.setOnFocusChangeListener(this);
        register_address_tiet.setOnFocusChangeListener(this);
        register_email_tiet.setOnFocusChangeListener(this);
        register_mobile_tiet.setOnFocusChangeListener(this);
        register_password_tiet.setOnFocusChangeListener(this);

        register_login_here_tv.setOnClickListener(this);
        return view;
    }

    private void init() {
        TextView toolbar_title_tv = getActivity().findViewById(R.id.toolbar_title_tv);
        toolbar_title_tv.setText(getString(R.string.sign_up));
        register_first_name_til = view.findViewById(R.id.register_first_name_til);
        register_last_name_til = view.findViewById(R.id.register_last_name_til);
        register_address_til = view.findViewById(R.id.register_address_til);
        register_email_til = view.findViewById(R.id.register_email_til);
        register_mobile_til = view.findViewById(R.id.register_mobile_til);
        register_password_til = view.findViewById(R.id.register_password_til);
        register_first_name_tiet = view.findViewById(R.id.register_first_name_tiet);
        register_last_name_tiet = view.findViewById(R.id.register_last_name_tiet);
        register_address_tiet = view.findViewById(R.id.register_address_tiet);
        register_email_tiet = view.findViewById(R.id.register_email_tiet);
        register_mobile_tiet = view.findViewById(R.id.register_mobile_tiet);
        register_password_tiet = view.findViewById(R.id.register_password_tiet);
        register_login_here_tv = view.findViewById(R.id.register_login_here_tv);
        register_sign_up_btn = view.findViewById(R.id.register_sign_up_btn);
        // register presenter instance
        register_presenter = new RegisterPresenter(this, getContext());
    }

    // onClickListener
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.register_sign_up_btn:
                register_presenter.validateRegisterInputs(register_first_name_til, register_last_name_til, register_address_til, register_email_til,register_mobile_til, register_password_til);
                break;

            case R.id.register_login_here_tv:
                register_presenter.onLoginHereClick();
                break;
        }
    }

    // TextInputEditText onFocusListener
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        int id = v.getId();

        if(!hasFocus) {
            switch (id) {
                case R.id.register_first_name_tiet:
                    register_presenter.validateSingleRegisterInput(register_first_name_til, getString(R.string.lowercase_first_name));
                    break;

                case R.id.register_last_name_tiet:
                    register_presenter.validateSingleRegisterInput(register_last_name_til, getString(R.string.lowercase_last_name));
                    break;

                case R.id.register_address_tiet:
                    register_presenter.validateSingleRegisterInput(register_address_til, getString(R.string.lowercase_address));
                    break;

                case R.id.register_email_tiet:
                    register_presenter.validateSingleRegisterInput(register_email_til, getString(R.string.lowercase_email));
                    break;

                case R.id.register_mobile_tiet:
                    register_presenter.validateSingleRegisterInput(register_mobile_til, getString(R.string.lowercase_mobile));
                    break;

                case R.id.register_password_tiet:
                    register_presenter.validateSingleRegisterInput(register_password_til, getString(R.string.lowercase_password));
                    break;
            }
        }
    }

    // Display error message below TextInputLayout
    @Override
    public void displayInputError(TextInputLayout textInputLayout, String errorMsg) {
        textInputLayout.setErrorEnabled(true);
        textInputLayout.setError(errorMsg);
    }

    // Remove error message below TextInputLayout
    @Override
    public void removeInputError(TextInputLayout textInputLayout) {
        textInputLayout.setErrorEnabled(false);
    }

    // Navigate to login fragment
    @Override
    public void navigateToLogin() {
                //                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginFragment()).commit();
        Toast.makeText(getContext(), "Go to login", Toast.LENGTH_SHORT).show();
    }

}
