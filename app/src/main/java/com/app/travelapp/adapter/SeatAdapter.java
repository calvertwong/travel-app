package com.app.travelapp.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.travelapp.R;
import com.app.travelapp.data.model.SeatsResponse;
import com.app.travelapp.seatselection.AbstractItem;
import com.app.travelapp.seatselection.CenterItem;
import com.app.travelapp.seatselection.EdgeItem;
import com.app.travelapp.seatselection.SelectableAdapter;

import java.util.ArrayList;
import java.util.List;

public class SeatAdapter extends SelectableAdapter<RecyclerView.ViewHolder> {
    static final String TAG = SeatAdapter.class.getSimpleName();
    private List<String> selectedSeatList = new ArrayList<>();
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    private List<AbstractItem> mItems;

    private static class EdgeViewHolder extends RecyclerView.ViewHolder {
        ImageView imgSeat;
        ImageView imgSeatSelected;

        public EdgeViewHolder(View itemView) {
            super(itemView);
            imgSeat = itemView.findViewById(R.id.img_seat);
            imgSeatSelected = itemView.findViewById(R.id.img_seat_selected);
        }
    }

    private static class CenterViewHolder extends RecyclerView.ViewHolder {
        ImageView imgSeat;
        private final ImageView imgSeatSelected;

        public CenterViewHolder(View itemView) {
            super(itemView);
            imgSeat = itemView.findViewById(R.id.img_seat);
            imgSeatSelected = itemView.findViewById(R.id.img_seat_selected);
        }
    }

    private static class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(View itemView) {
            super(itemView);
        }
    }

    public SeatAdapter(Context context, List<AbstractItem> items) {
        //mOnSeatSelected =  (OnSeatSelected)context;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mItems = items;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).getType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == AbstractItem.TYPE_CENTER) {
            View itemView = mLayoutInflater.inflate(R.layout.list_item_seat, parent, false);
            return new CenterViewHolder(itemView);
        } else if (viewType == AbstractItem.TYPE_EDGE) {
            View itemView = mLayoutInflater.inflate(R.layout.list_item_seat, parent, false);
            return new EdgeViewHolder(itemView);
        } else {
            View itemView = new View(mContext);
            return new EmptyViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {
        int type = mItems.get(position).getType();
        String status = mItems.get(position).getStatus();

        if (type == AbstractItem.TYPE_CENTER) {
            CenterItem item = (CenterItem) mItems.get(position);
            CenterViewHolder holder = (CenterViewHolder) viewHolder;

            if (status.equals("1")) {
                holder.imgSeat.setImageResource(R.drawable.ic_seats_reserved);
                holder.imgSeat.setOnClickListener(v -> {
                    Toast.makeText(mContext, item.getLabel() + " is reserved", Toast.LENGTH_SHORT).show();
                });
            } else {
                holder.imgSeat.setOnClickListener(v -> {
                    if(selectedSeatList.contains(item.getLabel())){
                        selectedSeatList.remove(item.getLabel());
                        holder.imgSeat.setImageResource(R.drawable.ic_seats_book);

                    }else{
                        selectedSeatList.add(item.getLabel());
                        holder.imgSeat.setImageResource(R.drawable.ic_seats_booked);
                    }
                    for(int i=0; i<selectedSeatList.size(); i++){
                        Log.d(TAG, "onBindViewHolder: " + selectedSeatList.get(i));
                    }
                    Toast.makeText(mContext, item.getLabel(), Toast.LENGTH_SHORT).show();
                });
            }

        } else if (type == AbstractItem.TYPE_EDGE) {
            EdgeItem item = (EdgeItem) mItems.get(position);
            EdgeViewHolder holder = (EdgeViewHolder) viewHolder;

            if (status.equals("1")) {
                holder.imgSeat.setImageResource(R.drawable.ic_seats_reserved);
                holder.imgSeat.setOnClickListener(v -> {
                    Toast.makeText(mContext, item.getLabel() + " is reserved", Toast.LENGTH_SHORT).show();
                });
            } else {
                holder.imgSeat.setOnClickListener(v -> {
                    if(selectedSeatList.contains(item.getLabel())){
                        selectedSeatList.remove(item.getLabel());
                        holder.imgSeat.setImageResource(R.drawable.ic_seats_book);
                    }else{
                        selectedSeatList.add(item.getLabel());
                        holder.imgSeat.setImageResource(R.drawable.ic_seats_booked);
                    }
                    for(int i=0; i<selectedSeatList.size(); i++){
                        Log.d(TAG, "onBindViewHolder: " + selectedSeatList.get(i));
                    }
                    Toast.makeText(mContext, item.getLabel(), Toast.LENGTH_SHORT).show();
                });
            }
        }
    }

}
