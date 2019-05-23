package com.app.travelapp.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.app.travelapp.R;
import com.app.travelapp.authentication.GetSeatsContract;
import com.app.travelapp.authentication.LoginContract;
import com.app.travelapp.data.DataSource;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowBusDetailsFragment extends Fragment implements GetSeatsContract.View {
    View view;
    private ShowBusDetailsPresenter presenter;


    public ShowBusDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_show_bus_details, container, false);
        presenter = new ShowBusDetailsPresenter(this, getContext());
        presenter.getSeatDetails();
        return view;

    }

}
