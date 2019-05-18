package com.app.travelapp.authentication;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.app.travelapp.R;


public class RegisterFragment extends Fragment {

    private static final String TAG = RegisterFragment.class.getSimpleName();
    private View view;
    private TextView toolbar_title_tv;

    public RegisterFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register, container, false);
        init();
        return view;
    }

    private void init() {
        toolbar_title_tv = getActivity().findViewById(R.id.toolbar_title_tv);
        toolbar_title_tv.setText(getString(R.string.sign_up));
    }

}
