package com.app.travelapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.travelapp.R;
import com.app.travelapp.data.model.CityItem;
import com.app.travelapp.data.model.CityResponse;

import java.util.List;

public class CityListRecyclerViewAdapter extends RecyclerView.Adapter<CityListRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = CityListRecyclerViewAdapter.class.getSimpleName();
    private List<CityItem> cityResponseList;
    private Context context;

    public CityListRecyclerViewAdapter(List<CityItem> cityResponseList, Context context) {
//        Log.d(TAG, "CityListRecyclerViewAdapter: " + cityResponseList);
        this.cityResponseList = cityResponseList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_city_list_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        CityItem cityItem = cityResponseList.get(position);

        Log.d("recyclerview", "onBindViewHolder: " + cityItem.getCityname());
        viewHolder.city_name_tv.setText(cityItem.getCityname());
    }

    @Override
    public int getItemCount() {
        return cityResponseList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView city_name_tv;
        ViewHolder(@NonNull View itemView) {
            super(itemView);

            city_name_tv = itemView.findViewById(R.id.city_name_tv);
        }
    }
}
