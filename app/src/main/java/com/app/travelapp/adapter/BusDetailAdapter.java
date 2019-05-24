package com.app.travelapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.travelapp.R;
import com.app.travelapp.data.model.BusInformationItem;

import java.util.List;

public class BusDetailAdapter extends RecyclerView.Adapter<BusDetailAdapter.MyViewHolder> {
    private List<BusInformationItem> busInfoItemList;
    private Context context;

    public BusDetailAdapter(List<BusInformationItem> businfoItemList, Context context) {
        this.busInfoItemList = businfoItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public BusDetailAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.bus_detail_item_layout,viewGroup,false);

        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull BusDetailAdapter.MyViewHolder myViewHolder, int i) {
        BusInformationItem businformationItem = busInfoItemList.get(i);
        myViewHolder.textViewBusDetailBusNo.setText("Bus No: " + businformationItem.getBusregistrationno());
        myViewHolder.textViewBusDetailType.setText("Type: "+businformationItem.getBustype());
        myViewHolder.textViewBusDetailDepartureTime.setText("Departure: "+businformationItem.getBusdeparturetime());
        myViewHolder.textViewBusDetailDuration.setText("Duration: "+businformationItem.getJournyduration());
        myViewHolder.textViewBusDetailBoardingTime.setText("Boarding Time: "+businformationItem.getBoardingtime());
        myViewHolder.textViewBusDetailDroppingTime.setText("Dropping Time: "+businformationItem.getDropingtime());
        myViewHolder.textViewBusDetailFare.setText("Fare : $"+businformationItem.getFare());

    }

    @Override
    public int getItemCount() {
        return busInfoItemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewBusDetailBusNo;
        TextView textViewBusDetailType;
        TextView textViewBusDetailDepartureTime;
        TextView textViewBusDetailDuration;
        TextView textViewBusDetailBoardingTime;
        TextView textViewBusDetailDroppingTime;
        TextView textViewBusDetailFare;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewBusDetailBusNo =itemView.findViewById(R.id.textViewBusDetailBusNo);
            textViewBusDetailType =itemView.findViewById(R.id.textViewBusDetailType);
            textViewBusDetailDepartureTime =itemView.findViewById(R.id.textViewBusDetailDepartureTime);
            textViewBusDetailDuration =itemView.findViewById(R.id.textViewBusDetailDuration);
            textViewBusDetailBoardingTime =itemView.findViewById(R.id.textViewBusDetailBoardingTime);
            textViewBusDetailDroppingTime =itemView.findViewById(R.id.textViewBusDetailDroppingTime);
            textViewBusDetailFare =itemView.findViewById(R.id.textViewBusDetailFare);
        }
    }
}
