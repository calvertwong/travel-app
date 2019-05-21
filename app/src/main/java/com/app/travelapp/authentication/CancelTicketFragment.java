package com.app.travelapp.authentication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.app.travelapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CancelTicketFragment extends Fragment {


    public CancelTicketFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cancel_ticket, container, false);
        return view;
    }

}
