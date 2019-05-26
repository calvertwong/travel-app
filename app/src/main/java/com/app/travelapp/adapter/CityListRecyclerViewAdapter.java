package com.app.travelapp.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.app.travelapp.R;
import com.app.travelapp.data.model.CityItem;
import com.app.travelapp.data.model.CityResponse;
import com.app.travelapp.route.citylist.CityListContract;
import com.app.travelapp.route.citylist.CityListPresenter;
import com.app.travelapp.route.home.HomeFragment;
import com.app.travelapp.route.home.HomePresenter;

import java.util.List;

public class CityListRecyclerViewAdapter extends RecyclerView.Adapter<CityListRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = CityListRecyclerViewAdapter.class.getSimpleName();
    private List<CityItem> city_items_list;
    private Context context;
    private String caller, caller_lat, caller_long;
    private CityListContract.Presenter city_list_presenter;

    public CityListRecyclerViewAdapter(List<CityItem> city_items_list, Context context, Bundle bundle) {
        this.city_items_list = city_items_list;
        this.context = context;
        if (bundle != null) {
            if (bundle.getString("origin") != null) {
                caller = context.getString(R.string.lowercase_origin);
                caller_lat = "startLat";
                caller_long = "startLong";
            } else if (bundle.getString("destination") != null) {
                caller = context.getString(R.string.lowercase_destination);
                caller_lat = "endLat";
                caller_long = "endLong";
            }
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
        CityItem cityItem = city_items_list.get(position);

        viewHolder.city_name_tv.setText(cityItem.getCityname());
    }

    @Override
    public int getItemCount() {
        return city_items_list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView city_name_tv;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            city_name_tv = itemView.findViewById(R.id.city_name_tv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String city_name = city_items_list.get(getLayoutPosition()).getCityname();
            String city_lat = city_items_list.get(getLayoutPosition()).getCitylatitude();
            String city_long = city_items_list.get(getLayoutPosition()).getCitylongtitude();
            Bundle bundle = new Bundle();
            bundle.putString(caller, city_name);
            HomeFragment homeFragment = new HomeFragment();
            homeFragment.setArguments(bundle);

            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, homeFragment).addToBackStack(null).commit();

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(caller, city_name);
            editor.putString(caller_lat, city_lat);
            editor.putString(caller_long, city_long);
            editor.apply();
        }
    }
}
