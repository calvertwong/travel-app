package com.app.travelapp.seatselection;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.travelapp.R;
import com.app.travelapp.adapter.SeatAdapter;
import com.app.travelapp.data.model.SeatInformationItem;
import com.app.travelapp.payment.PaymentFragment;
import com.app.travelapp.ui.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class SeatFragment extends Fragment implements SeatSelectionContract.View, OnSeatSelected {
    private static final String TAG = SeatFragment.class.getSimpleName();
    private TextView tv_toolbar_title;
    private View view;
    private static final int COLUMNS = 5;
    private TextView textViewSeatSelected;
    private RecyclerView recyclerView;
    private SeatSelectionPresenter seatSelectionPresenter;


    public SeatFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_seat, container, false);
        tv_toolbar_title = getActivity().findViewById(R.id.toolbar_title_tv);
        textViewSeatSelected = view.findViewById(R.id.textViewSeatSelected);
        tv_toolbar_title.setText("Seat Selection");

        seatSelectionPresenter = new SeatSelectionPresenter(this, getContext());
        seatSelectionPresenter.getSeatDetails();

        return view;
    }

    @Override
    public void onSeatSelected(int count) {
        textViewSeatSelected.setText("Book " + count + " seats");
    }

    @Override
    public void parseSeatResponse(List<SeatInformationItem> seatResponse) {
        int totalSeats = Integer.parseInt(seatResponse.get(0).getTotalseat());

        List<AbstractItem> items = new ArrayList<>();

        int seatNum = 1;
        for (int i = 0; i < totalSeats + totalSeats / COLUMNS + totalSeats % COLUMNS + 1; i++) {
            if (i % COLUMNS == 0 || i % COLUMNS == 4) {
                items.add(new EdgeItem("s" + seatNum++));
            } else if (i % COLUMNS == 1 || i % COLUMNS == 3) {
                items.add(new CenterItem("s" + seatNum++));
            } else {
                items.add(new EmptyItem(""));
            }
        }
        PaymentFragment paymentFragment = new PaymentFragment();
        textViewSeatSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,paymentFragment).addToBackStack(null).commit();

            }
        });

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), COLUMNS);
        recyclerView = view.findViewById(R.id.recyclerViewSeat);
        recyclerView.setLayoutManager(layoutManager);

        SeatAdapter adapter = new SeatAdapter(getContext(), items);
        recyclerView.setAdapter(adapter);
    }
}