package com.app.travelapp.authentication;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.travelapp.R;

import java.util.Objects;

public class RegisterFragment extends Fragment {

    private static final String TAG = RegisterFragment.class.getSimpleName();
    private View view;

    public RegisterFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register, container, false);
        init();
        return view;
    }

    private void init() {
        //Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar()).setTitle(getString(R.string.sign_up));
    }

}
