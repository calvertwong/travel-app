package com.app.travelapp.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.app.travelapp.R;
import com.app.travelapp.authentication.login.LoginFragment;
import com.app.travelapp.route.home.HomeFragment;
import android.support.v4.app.NotificationCompat;

public class SummaryFragment extends Fragment {
    private View view;
    private TextView tv_busNo, tv_noOfSeats, tv_totalAmount,tv_toolbar_title,tv_seats_selected;
    private Button btn_home, btn_logout;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private NotificationManager notifyManager;
    private static final int NOTIFICATION_ID = 0;


    public SummaryFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_summary,container,false);
        init();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String busNo = preferences.getString("busId","");
        String noOfSeats = preferences.getString("noOfSeats","");
        String totalAmount = preferences.getString("totalAmount","");
        String seats = preferences.getString("selectedseats","");
        tv_toolbar_title.setText("Summary");

        tv_busNo.setText("Bus No :" + busNo);
        tv_noOfSeats.setText("No of Seats :" + noOfSeats);
        tv_seats_selected.setText("Seat No :" + seats);
        tv_totalAmount.setText("Total Amount paid :" + totalAmount);
        sendNotification();
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).addToBackStack(null).commit();
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = sharedPreferences.edit();
                editor.clear().apply();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginFragment()).addToBackStack(null).commit();
            }
        });

        return view;
    }


    private void init() {
        tv_busNo = view.findViewById(R.id.textViewBusId);
        tv_noOfSeats = view.findViewById(R.id.textViewNoOfSeat);
        tv_totalAmount = view.findViewById(R.id.textViewTotalAmount);
        tv_toolbar_title = getActivity().findViewById(R.id.toolbar_title_tv);
        btn_home = view.findViewById(R.id.buttonHome);
        btn_logout = view.findViewById(R.id.buttonLogout);
        tv_seats_selected = view.findViewById(R.id.textViewSeatsSelected);
        sharedPreferences = getActivity().getSharedPreferences("userPre", Context.MODE_PRIVATE);
        notifyManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
    }
    private void sendNotification() {
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(getContext())
                .setContentTitle("Payment is Processed!")
                .setContentText("Your payment is being processed.")
                .setSmallIcon(R.drawable.ic_payment);
        Notification myNotification = notifyBuilder.build();
        notifyManager.notify(NOTIFICATION_ID,myNotification);
    }
}
