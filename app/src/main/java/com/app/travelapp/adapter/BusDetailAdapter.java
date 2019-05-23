package com.app.travelapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.travelapp.R;
import com.app.travelapp.model.BusInformationItem;

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

    @Override
    public void onBindViewHolder(@NonNull BusDetailAdapter.MyViewHolder myViewHolder, int i) {
        BusInformationItem businformationItem = busInfoItemList.get(i);
        myViewHolder.textViewBusDetailTime.setText(businformationItem.getBusdeparturetime());
        myViewHolder.textViewBusDetailType.setText(businformationItem.getBustype());
        myViewHolder.textViewBusDetailFare.setText(businformationItem.getFare());

    }

    @Override
    public int getItemCount() {
        return busInfoItemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewBusDetailTime,textViewBusDetailType,textViewBusDetailFare,textViewBusDetailAvailableSeats;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewBusDetailTime =itemView.findViewById(R.id.textViewBusDetailTime);
            textViewBusDetailType =itemView.findViewById(R.id.textViewBusDetailType);
            textViewBusDetailFare =itemView.findViewById(R.id.textViewBusDetailFare);
            //textViewBusDetailAvailableSeats =itemView.findViewById(R.id.textViewBusDetailAvailableSeats);
        }
    }
}
