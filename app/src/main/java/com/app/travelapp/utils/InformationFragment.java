package com.app.travelapp.utils;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.travelapp.R;

public class InformationFragment extends Fragment {
    private View view;
    private TextView textView, tv_toolbar_title;

    public InformationFragment() {

    }

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.information_fragment, container, false);
        textView = view.findViewById(R.id.tv_info);
        tv_toolbar_title = getActivity().findViewById(R.id.toolbar_title_tv);
        tv_toolbar_title.setText("Information");
        textView.setText("-- MVP Architecture \n" +
                "\n-- Authentication Validation using Regular Expression (Regex) \n" +
                "\n-- RecyclerView with CardView\n" +
                "\n-- Retrofit Network Library\n" +
                "\n-- RxJava Network Library(Observer pattern) \n" +
                "\n-- Seat selection - 3rd Party Library \n" +
                "\n-- Paypal SDK \n" +
                "\n-- SQLite Database \n" +
                "\n-- Google Maps \n"
//                        +
//                "\n-- Push Notification \n" +
//                "\n-- Email Notification \n"
        );

        return view;
    }
}

