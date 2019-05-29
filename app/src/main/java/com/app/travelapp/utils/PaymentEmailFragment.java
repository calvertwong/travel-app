package com.app.travelapp.utils;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.app.travelapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentEmailFragment extends Fragment {
    Button button;
    private TextView tv_toolbar_title;
    Intent intent;



    public PaymentEmailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_payment_email, container, false);
        button = view.findViewById(R.id.EmailNotify);
        tv_toolbar_title = getActivity().findViewById(R.id.toolbar_title_tv);
        tv_toolbar_title.setText("Payment Email Confirm");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
        return view;
    }

    private void sendEmail() {
        intent =  new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String sendto = "ask@gmail.com";
        intent.putExtra(Intent.EXTRA_EMAIL,sendto);
        intent.putExtra(Intent.EXTRA_SUBJECT,"payment confirmation");
        intent.putExtra(Intent.EXTRA_TEXT,"this email confirms you that you have succesful pay the order");
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));

    }

}
