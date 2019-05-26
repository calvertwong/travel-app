package com.app.travelapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


import com.app.travelapp.data.model.SeatInformationItem;

import java.util.List;

public class MySeatAdaptor extends RecyclerView.Adapter<MySeatAdaptor.ViewHolder>{
    private Context context;
    private List<SeatInformationItem> list;
    private static final String TAG = MySeatAdaptor.class.getSimpleName();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
