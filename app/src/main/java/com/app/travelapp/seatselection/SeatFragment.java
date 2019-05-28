package com.app.travelapp.seatselection;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import com.app.travelapp.data.model.Seat;
import com.app.travelapp.data.model.SeatInformationItem;
import com.app.travelapp.payment.PaymentFragment;
import com.app.travelapp.ui.BusDetailFragment;
import com.app.travelapp.utils.SelectedSeatClass;
import com.app.travelapp.payment.PaymentFragment;
import com.app.travelapp.ui.MainActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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


    public SeatFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_seat, container, false);
        tv_toolbar_title = getActivity().findViewById(R.id.toolbar_title_tv);
        textViewSeatSelected = view.findViewById(R.id.textViewSeatSelected);
        tv_toolbar_title.setText("Seat Selection");

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String busId = preferences.getString("busId", "");
        seatSelectionPresenter = new SeatSelectionPresenter(this, getContext());
        seatSelectionPresenter.getSeatDetails(busId);

        textViewSeatSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new PaymentFragment()).addToBackStack(null).commit();
            }
        });

        return view;
    }

    @Override
    public void onSeatSelected(int count) {
        textViewSeatSelected.setText("Book " + count + " seats");
    }

    @Override
    public void parseSeatResponse(List<SeatInformationItem> seatResponse) {
//        try {
//            JSONObject jsonObject = new JSONObject(seatResponse);
//            JSONArray jsonArray = jsonObject.getJSONArray("seatinformation");
//            JSONObject jsonObject1 = jsonArray.getJSONObject(0);
//            Log.d(TAG, "jsonObject1: " + jsonObject1.toString());
//            int totalSeats = Integer.parseInt(jsonObject1.getString("totalseat"));
//            List<Seat> seatList = new ArrayList<>();
//            for (int i = 1; i <= totalSeats; i++) {
//                String id = "s" + i;
//                String status = jsonObject1.getString(id);
//                Seat mSeat = new Seat(id, Integer.parseInt(status));
//                seatList.add(mSeat);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

//        for (int i=0; i<Integer.parseInt(seatResponse.get(0).getTotalseat());i++){
//            seatResponse.get(0).get
//        }

        List<AbstractItem> items = new ArrayList<>();
        int totalSeats = Integer.parseInt(seatResponse.get(0).getTotalseat());

        int seatNum = 1;
        for (int i = 1; i <= totalSeats + totalSeats / COLUMNS + totalSeats % COLUMNS + 1; i++) {
            if (i == 1) {
                items.add(new EdgeItem("s1", seatResponse.get(0).getS1()));
            } else if (i == 2) {
                items.add(new CenterItem("s2", seatResponse.get(0).getS2()));
                items.add(new EmptyItem("", ""));
            } else if (i == 3) {
                items.add(new CenterItem("s3", seatResponse.get(0).getS3()));
            } else if (i == 4) {
                items.add(new EdgeItem("s4", seatResponse.get(0).getS4()));
            } else if (i == 5) {
                items.add(new EdgeItem("s5", seatResponse.get(0).getS5()));
            } else if (i == 6) {
                items.add(new CenterItem("s6", seatResponse.get(0).getS6()));
                items.add(new EmptyItem("", ""));
            } else if (i == 7) {
                items.add(new CenterItem("s7", seatResponse.get(0).getS7()));
            } else if (i == 8) {
                items.add(new EdgeItem("s8", seatResponse.get(0).getS8()));
            } else if (i == 9) {
                items.add(new EdgeItem("s9", seatResponse.get(0).getS9()));
            } else if (i == 10) {
                items.add(new CenterItem("s10", seatResponse.get(0).getS10()));
                items.add(new EmptyItem("", ""));
            } else if (i == 11) {
                items.add(new CenterItem("s11", seatResponse.get(0).getS11()));
            } else if (i == 12) {
                items.add(new EdgeItem("s12", seatResponse.get(0).getS12()));
            } else if (i == 13) {
                items.add(new EdgeItem("s13", seatResponse.get(0).getS13()));
            } else if (i == 14) {
                items.add(new CenterItem("s14", seatResponse.get(0).getS14()));
                items.add(new EmptyItem("", ""));
            } else if (i == 15) {
                items.add(new CenterItem("s15", seatResponse.get(0).getS15()));
            } else if (i == 16) {
                items.add(new EdgeItem("s16", seatResponse.get(0).getS16()));
            } else if (i == 17) {
                items.add(new EdgeItem("s17", seatResponse.get(0).getS17()));
            } else if (i == 18) {
                items.add(new CenterItem("s18", seatResponse.get(0).getS18()));
                items.add(new EmptyItem("", ""));
            } else if (i == 19) {
                items.add(new CenterItem("s19", seatResponse.get(0).getS19()));
            } else if (i == 20) {
                items.add(new EdgeItem("s20", seatResponse.get(0).getS20()));
            } else if (i == 21) {
                items.add(new EdgeItem("s21", seatResponse.get(0).getS21()));
            } else if (i == 22) {
                items.add(new CenterItem("s22", seatResponse.get(0).getS22()));
                items.add(new EmptyItem("", ""));
            } else if (i == 23) {
                items.add(new CenterItem("s23", seatResponse.get(0).getS23()));
            } else if (i == 24) {
                items.add(new EdgeItem("s24", seatResponse.get(0).getS24()));
            } else if (i == 25) {
                items.add(new EdgeItem("s25", seatResponse.get(0).getS25()));
            } else if (i == 26) {
                items.add(new CenterItem("s26", seatResponse.get(0).getS26()));
                items.add(new EmptyItem("", ""));
            } else if (i == 27) {
                items.add(new CenterItem("s27", seatResponse.get(0).getS27()));
            } else if (i == 28) {
                items.add(new EdgeItem("s28", seatResponse.get(0).getS28()));
            } else if (i == 29) {
                items.add(new EdgeItem("s29", seatResponse.get(0).getS29()));
            } else if (i == 30) {
                items.add(new CenterItem("s30", seatResponse.get(0).getS30()));
                items.add(new EmptyItem("", ""));
            } else if (i == 31) {
                items.add(new CenterItem("s31", seatResponse.get(0).getS31()));
            } else if (i == 32) {
                items.add(new EdgeItem("s32", seatResponse.get(0).getS32()));
            } else if (i == 33) {
                items.add(new EdgeItem("s33", seatResponse.get(0).getS33()));
            } else if (i == 34) {
                items.add(new CenterItem("s34", seatResponse.get(0).getS34()));
                items.add(new EmptyItem("", ""));
            } else if (i == 35) {
                items.add(new CenterItem("s35", seatResponse.get(0).getS35()));
            } else if (i == 36) {
                items.add(new EdgeItem("s36", seatResponse.get(0).getS36()));
            } else if (i == 37) {
                items.add(new EdgeItem("s37", seatResponse.get(0).getS37()));
            } else if (i == 38) {
                items.add(new CenterItem("s38", seatResponse.get(0).getS38()));
                items.add(new EmptyItem("", ""));
            } else if (i == 39) {
                items.add(new CenterItem("s39", seatResponse.get(0).getS39()));
            } else if (i == 40) {
                items.add(new EdgeItem("s40", seatResponse.get(0).getS40()));
            } else if (i == 41) {
                items.add(new EdgeItem("s41", seatResponse.get(0).getS41()));
            } else if (i == 42) {
                items.add(new CenterItem("s42", seatResponse.get(0).getS42()));
                items.add(new EmptyItem("", ""));
            } else if (i == 43) {
                items.add(new CenterItem("s43", seatResponse.get(0).getS43()));
            } else if (i == 44) {
                items.add(new EdgeItem("s44", seatResponse.get(0).getS44()));
            } else if (i == 45) {
                items.add(new EdgeItem("s45", seatResponse.get(0).getS45()));
            } else if (i == 46) {
                items.add(new CenterItem("s46", seatResponse.get(0).getS46()));
                items.add(new EmptyItem("", ""));
            } else if (i == 47) {
                items.add(new CenterItem("s47", seatResponse.get(0).getS47()));
            }
        }


        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), COLUMNS);
        recyclerView = view.findViewById(R.id.recyclerViewSeat);
        recyclerView.setLayoutManager(layoutManager);

        SeatAdapter adapter = new SeatAdapter(getContext(), items);
        recyclerView.setAdapter(adapter);
    }
}