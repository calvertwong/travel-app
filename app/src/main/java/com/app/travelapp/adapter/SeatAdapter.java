package com.app.travelapp.adapter;

import android.content.Context;
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

import java.util.List;

public class SeatAdapter extends SelectableAdapter<RecyclerView.ViewHolder> {
    //private OnSeatSelected mOnSeatSelected;

    private static class EdgeViewHolder extends RecyclerView.ViewHolder {
        ImageView imgSeat;
        private final ImageView imgSeatSelected;

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

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    private List<AbstractItem> mItems;

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
        if (type == AbstractItem.TYPE_CENTER) {
            final CenterItem item = (CenterItem) mItems.get(position);
            CenterViewHolder holder = (CenterViewHolder) viewHolder;

            holder.imgSeat.setOnClickListener(v -> {
                toggleSelection(position);

                Toast.makeText(mContext, mItems.get(position).getLabel(), Toast.LENGTH_SHORT).show();
                //mOnSeatSelected.onSeatSelected(getSelectedItemCount());
            });

            holder.imgSeatSelected.setVisibility(isSelected(position) ? View.VISIBLE : View.INVISIBLE);

        } else if (type == AbstractItem.TYPE_EDGE) {
            final EdgeItem item = (EdgeItem) mItems.get(position);
            EdgeViewHolder holder = (EdgeViewHolder) viewHolder;

            holder.imgSeat.setOnClickListener(v -> {
                toggleSelection(position);
                Toast.makeText(mContext, mItems.get(position).getLabel(), Toast.LENGTH_SHORT).show();

                //mOnSeatSelected.onSeatSelected(getSelectedItemCount());
            });

            holder.imgSeatSelected.setVisibility(isSelected(position) ? View.VISIBLE : View.INVISIBLE);
        }
    }

}
