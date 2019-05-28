package com.app.travelapp.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.app.travelapp.R;
import com.app.travelapp.adapter.BusDetailAdapter;
import com.app.travelapp.data.BusDetailDataRepository;
import com.app.travelapp.data.BusDetailDataSource;
import com.app.travelapp.data.RouteIdDataRepository;
import com.app.travelapp.data.RouteIdDataSource;
import com.app.travelapp.data.model.BusInformationItem;
import com.app.travelapp.data.model.RouteResponse;

public class BusDetailFragment extends Fragment implements BusDetailDataRepository.GetBusDetailCallback, RouteIdDataRepository.GetRouteCallback {
    private static final String TAG = BusDetailFragment.class.getSimpleName();
    private View view;
    private TextView tv_toolbar_title;
    private TextView textViewCurrentDate;
    private String currentDate;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private BusDetailAdapter busDetailAdapter;
    private BusDetailDataSource busDetailDataSource;
    private RouteIdDataSource routeIdDataSource;
    private ProgressDialog progressDialog;

    public BusDetailFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bus_detail, container, false);

        init();
        textViewCurrentDate.setText(currentDate);
        return view;
    }

    @SuppressLint("SetTextI18n")
    private void init() {
        tv_toolbar_title = getActivity().findViewById(R.id.toolbar_title_tv);
        currentDate = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());
        textViewCurrentDate = view.findViewById(R.id.textViewCurrentDate);
        recyclerView = view.findViewById(R.id.recyclerViewBusDetail);
        layoutManager = new LinearLayoutManager(getContext());
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String origin = preferences.getString("origin", "");
        String destination = preferences.getString("destination", "");
        tv_toolbar_title.setText(origin + " to " + destination);

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Getting routes");
        progressDialog.show();

        String startLat = preferences.getString("startLat", "");
        String startLong = preferences.getString("startLong", "");
        String endLat = preferences.getString("endLat", "");
        String endLong = preferences.getString("endLong", "");

        routeIdDataSource = new RouteIdDataRepository(getContext());
        routeIdDataSource.getRoute(this, startLat, startLong, endLat, endLong);
    }

    @Override
    public void onBusDetailLoaded(List<BusInformationItem> busDetailResponse) {
        recyclerView.setLayoutManager(layoutManager);
        busDetailAdapter = new BusDetailAdapter(busDetailResponse, getContext());
        recyclerView.setAdapter(busDetailAdapter);
        progressDialog.dismiss();
    }

    //routeResponse == null on invalid route or no route being setup in server
    // else it is a route id
    @Override
    public void onRoutedLoaded(RouteResponse routeResponse) {
        if(routeResponse!= null){
            busDetailDataSource = new BusDetailDataRepository(getContext());
            busDetailDataSource.getBusDetail(this, routeResponse.getRoute().get(0).getId());
        }else {
            progressDialog.dismiss();
            Toast.makeText(getContext(), "No route", Toast.LENGTH_SHORT).show();
        }
    }
}

