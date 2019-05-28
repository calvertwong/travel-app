package com.app.travelapp.route.home;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.button.MaterialButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.travelapp.R;
import com.app.travelapp.route.citylist.CityListFragment;
import com.app.travelapp.ui.BusDetailFragment;
import com.app.travelapp.ui.MapFragment;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class HomeFragment extends Fragment implements View.OnClickListener, HomeContract.View {
    private static final String TAG = HomeFragment.class.getSimpleName();
    private View view;
    private TextView origin_tv, destination_tv, calendar_day_tv, calendar_day_name_tv, calendar_month_tv, calendar_year_tv;
    private MaterialButton show_map_btn, search_bus_btn;
    private LinearLayout journey_date_ll;
    private HomePresenter home_presenter;
    private Bundle bundle;

    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        init();

        origin_tv.setOnClickListener(this);
        destination_tv.setOnClickListener(this);
        show_map_btn.setOnClickListener(this);
        search_bus_btn.setOnClickListener(this);

        return view;
    }

    private void init() {
        TextView toolbar_title_tv = getActivity().findViewById(R.id.toolbar_title_tv);
        toolbar_title_tv.setText(getString(R.string.app_name));

        origin_tv = view.findViewById(R.id.origin_tv);
        destination_tv = view.findViewById(R.id.destination_tv);
        calendar_day_tv = view.findViewById(R.id.calendar_day_tv);
        calendar_day_name_tv = view.findViewById(R.id.calendar_day_name_tv);
        calendar_month_tv = view.findViewById(R.id.calendar_month_tv);
        calendar_year_tv = view.findViewById(R.id.calendar_year_tv);
        show_map_btn = view.findViewById(R.id.show_map_btn);
        search_bus_btn = view.findViewById(R.id.search_bus_btn);

        home_presenter = new HomePresenter(this);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String origin = preferences.getString("origin", "");
        String destination = preferences.getString("destination", "");

        origin_tv.setText(origin);
        destination_tv.setText(destination);

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        calendar_day_name_tv.setText(localDate.getDayOfWeek().toString());
        calendar_day_tv.setText(String.valueOf(localDate.getDayOfMonth()));
        calendar_month_tv.setText(String.valueOf(localDate.getMonth()));
        calendar_year_tv.setText(String.valueOf(localDate.getYear()));
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.origin_tv:
                //need bundle to tell sharedpreferences which one is requesting the location, origin or destination
                CityListFragment cityListFragment = new CityListFragment();
                Bundle bundle = new Bundle();
                bundle.putString("origin", getString(R.string.lowercase_origin));
                cityListFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, cityListFragment).addToBackStack(null).commit();
                break;
            case R.id.destination_tv:
                cityListFragment = new CityListFragment();
                bundle = new Bundle();
                bundle.putString("destination", getString(R.string.lowercase_destination));
                cityListFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, cityListFragment).addToBackStack(null).commit();
                break;

            case R.id.show_map_btn:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new MapFragment()).addToBackStack(null).commit();
                break;

            case R.id.search_bus_btn:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new BusDetailFragment()).addToBackStack(null).commit();
                break;
        }
    }
}
