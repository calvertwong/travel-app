package com.app.travelapp.seat;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.app.travelapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowSeatDetailsFragment extends Fragment implements GetSeatsContract.View {
    View view;
    private ShowSeatDetailsPresenter presenter;


    public ShowSeatDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_show_bus_details, container, false);
        presenter = new ShowSeatDetailsPresenter(this, getContext());
        presenter.getSeatDetails();
        return view;

    }

}
