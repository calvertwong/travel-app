package com.app.travelapp.adapter;

import android.content.Context;
import android.os.Bundle;
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
import com.app.travelapp.route.home.HomeFragment;
import com.app.travelapp.route.home.HomePresenter;

import java.util.List;

public class CityListRecyclerViewAdapter extends RecyclerView.Adapter<CityListRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = CityListRecyclerViewAdapter.class.getSimpleName();
    private List<CityItem> cityResponseList;
    private Context context;
    private String caller;

    public CityListRecyclerViewAdapter(List<CityItem> cityResponseList, Context context, Bundle bundle) {
        this.cityResponseList = cityResponseList;
        this.context = context;
        if(bundle.getString("origin") != null){
            caller = bundle.getString("origin");
        }else if(bundle.getString("destination") != null){
            caller = bundle.getString("destination");
        }
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

        viewHolder.city_name_tv.setText(cityItem.getCityname());
    }

    @Override
    public int getItemCount() {
        return cityResponseList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView city_name_tv;
        ViewHolder(@NonNull View itemView) {
            super(itemView);

            city_name_tv = itemView.findViewById(R.id.city_name_tv);
        }

        @Override
        public void onClick(View v) {
            String city_name = cityResponseList.get(getLayoutPosition()).getCityname();
            Bundle bundle = new Bundle();
            bundle.putString(caller, city_name);
            HomeFragment homeFragment = new HomeFragment();
            homeFragment.setArguments(bundle);
            HomePresenter home_presenter = new HomePresenter();
            home_presenter.receiveOriginDestinationFromCityListRecyclerView(caller, city_name);
        }
    }
}
