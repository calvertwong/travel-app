package com.app.travelapp.route.citylist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.travelapp.R;
import com.app.travelapp.adapter.CityListRecyclerViewAdapter;
import com.app.travelapp.data.DataRepository;
import com.app.travelapp.data.DataSource;
import com.app.travelapp.data.model.CityItem;

import java.util.List;


public class CityListFragment extends Fragment implements CityListContract.View {
    private static final String TAG = CityListFragment.class.getSimpleName();
    private RecyclerView city_list_rv;
    private CityListRecyclerViewAdapter city_list_rv_adapter;
    private RecyclerView.LayoutManager layout_manager;
    private View view;
    private DataSource data_source;
    private Bundle bundle;
    private CityListPresenter city_list_presenter;

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
        layout_manager = new LinearLayoutManager(getContext());
        data_source = new DataRepository(getContext());
        bundle = getArguments();
        city_list_presenter = new CityListPresenter(this);
        city_list_presenter.getCityFromSource(data_source);
    }

    @Override
    public void setupCityListRV(List<CityItem> cityItems) {
        city_list_rv.setLayoutManager(layout_manager);
        city_list_rv_adapter = new CityListRecyclerViewAdapter(cityItems, getContext(), bundle);
        city_list_rv.setAdapter(city_list_rv_adapter);
    }
}
