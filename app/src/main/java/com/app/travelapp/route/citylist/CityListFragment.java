package com.app.travelapp.route.citylist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.travelapp.R;
import com.app.travelapp.adapter.CityListRecyclerViewAdapter;
import com.app.travelapp.data.DataRepository;
import com.app.travelapp.data.DataSource;
import com.app.travelapp.data.model.CityItem;

import java.util.List;


public class CityListFragment extends Fragment implements DataRepository.GetCityCallback {
    private RecyclerView city_list_rv;
    private CityListRecyclerViewAdapter cityListRecyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private View view;
    private DataSource dataSource;
    private Bundle bundle;

    public CityListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_city_list, container, false);

        init();

        return view;
    }

    private void init() {
        city_list_rv = view.findViewById(R.id.city_list_rv);
        layoutManager = new LinearLayoutManager(getContext());
        dataSource = new DataRepository(getContext());
        bundle = getArguments();
        dataSource.getCity(this);
    }


    @Override
    public void onCityLoaded(List<CityItem> cityResponse) {
        city_list_rv.setLayoutManager(layoutManager);
        cityListRecyclerViewAdapter = new CityListRecyclerViewAdapter(cityResponse, getContext(), bundle);
        city_list_rv.setAdapter(cityListRecyclerViewAdapter);
    }
}
