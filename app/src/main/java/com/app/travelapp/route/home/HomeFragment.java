package com.app.travelapp.route.home;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.travelapp.R;
import com.app.travelapp.route.calendar.CalendarFragment;
import com.app.travelapp.route.citylist.CityListFragment;

public class HomeFragment extends Fragment implements View.OnClickListener, HomeContract.View {
    private static final String TAG = HomeFragment.class.getSimpleName();
    private View view;
    private TextView origin_tv, destination_tv, calendar_day_tv, calendar_day_name_tv, calendar_month_tv, calendar_year_tv;
    private MaterialButton home_today_btn, home_tomorrow_btn, search_bus_btn;
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
        journey_date_ll.setOnClickListener(this);
        home_today_btn.setOnClickListener(this);
        home_tomorrow_btn.setOnClickListener(this);
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
        home_today_btn = view.findViewById(R.id.home_today_btn);
        home_tomorrow_btn = view.findViewById(R.id.home_tomorrow_btn);
        search_bus_btn = view.findViewById(R.id.search_bus_btn);
        journey_date_ll = view.findViewById(R.id.journey_date_ll);

        home_presenter = new HomePresenter(this);
        bundle = getArguments();
        if(bundle == null){
            Toast.makeText(getContext(), "bundle null", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getContext(), "not null", Toast.LENGTH_SHORT).show();
            setTexts(bundle);
        }

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String origin = preferences.getString("origin", "");
        String destination = preferences.getString("destination", "");

        origin_tv.setText(origin);
        destination_tv.setText(destination);
        Log.d(TAG, "init: origin   " + origin);
        Log.d(TAG, "init: destination   " + destination);

    }

    private void setTexts(Bundle bundle) {
        if(bundle.getString("origin") != null){
            origin_tv.setText(bundle.getString("origin"));
        }
        if(bundle.getString("destination") != null){
            destination_tv.setText(bundle.getString("destination"));
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.origin_tv:
                CityListFragment cityListFragment = new CityListFragment();
                Bundle bundle = new Bundle();
                bundle.putString("origin", "origin");
                cityListFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, cityListFragment).addToBackStack(null).commit();
                break;
            case R.id.destination_tv:
                cityListFragment = new CityListFragment();
                bundle = new Bundle();
                bundle.putString("destination", "destination");
                cityListFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, cityListFragment).addToBackStack(null).commit();
                break;

            case R.id.journey_date_ll:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new CalendarFragment()).addToBackStack(null).commit();
                break;

            case R.id.home_today_btn:
                break;

            case R.id.home_tomorrow_btn:
                break;

            case R.id.search_bus_btn:
                break;
        }
    }

    public void setOriginDestinationText(String caller, String city_name) {
//            origin_tv.setText(bundle.getString("origin"));
//            destination_tv.setText(bundle.getString("destination"));
            Log.d(TAG, "setOriginDestinationText: " + caller + "----" + city_name);
    }

}