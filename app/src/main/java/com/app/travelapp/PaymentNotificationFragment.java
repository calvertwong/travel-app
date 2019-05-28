package com.app.travelapp;


import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class PaymentNotificationFragment extends Fragment {
    private Button button;
    private View view;
    private NotificationManager notifyManager;
    private static final int NOTIFICATION_ID = 0;
    private TextView tv_toolbar_title;


    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_payment_notification,container,false);

        init();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });
        return view;
    }

    private void init() {
        button = view.findViewById(R.id.buttonNotify);
        notifyManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        tv_toolbar_title = getActivity().findViewById(R.id.toolbar_title_tv);
        tv_toolbar_title.setText("Payment Notification");
    }

    public void sendNotification(){
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(getContext())
                .setContentTitle("Payment is Processed!")
                .setContentText("You payment is being processed.")
                .setSmallIcon(R.drawable.ic_payment);
        Notification myNotification = notifyBuilder.build();
        notifyManager.notify(NOTIFICATION_ID,myNotification);
    }
}
