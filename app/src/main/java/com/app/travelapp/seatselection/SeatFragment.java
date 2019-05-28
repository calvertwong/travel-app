package com.app.travelapp.seatselection;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.travelapp.R;
import com.app.travelapp.adapter.SeatAdapter;

import java.util.ArrayList;
import java.util.List;

public class SeatFragment extends Fragment implements OnSeatSelected{

    private TextView tv_toolbar_title;
    private View view;
    private static final int COLUMNS = 5;
    private TextView textViewSeatSelected;
    private RecyclerView recyclerView;

    public SeatFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_seat,container,false);
        tv_toolbar_title = getActivity().findViewById(R.id.toolbar_title_tv);
        textViewSeatSelected = view.findViewById(R.id.textViewSeatSelected);
        tv_toolbar_title.setText("Seat Selection");

        List<AbstractItem> items = new ArrayList<>();
        for (int i=0; i<60; i++) {

            if (i%COLUMNS==0 || i%COLUMNS==4) {
                items.add(new EdgeItem(String.valueOf(i)));
            } else if (i%COLUMNS==1 || i%COLUMNS==3) {
                items.add(new CenterItem(String.valueOf(i)));
            } else {
                items.add(new EmptyItem(String.valueOf(i)));
            }
        }

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), COLUMNS);
        recyclerView = view.findViewById(R.id.recyclerViewSeat);
        recyclerView.setLayoutManager(layoutManager);

        SeatAdapter adapter = new SeatAdapter(getContext(), items);
        //SeatAdapter adapter = new SeatAdapter(getApplicationContext(), items);
        recyclerView.setAdapter(adapter);

        return view;
    }


    @Override
    public void onSeatSelected(int count) {
        textViewSeatSelected.setText("Book "+count+" seats");
    }
}