package com.app.travelapp.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.app.travelapp.R;

public class BusDetailFragment extends Fragment {
    private static final String TAG = BusDetailFragment.class.getSimpleName();
    private View view;
    private TextView tv_toolbar_title;
    private TextView textViewCurrentDate;
    private String currentDate;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bus_detail,container,false);

        init();
        tv_toolbar_title.setText("From - To");
        textViewCurrentDate.setText(currentDate);

        return view;
    }

    private void init() {
        tv_toolbar_title = getActivity().findViewById(R.id.toolbar_title_tv);
        currentDate = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());
        textViewCurrentDate = view.findViewById(R.id.textViewCurrentDate);
    }
}
