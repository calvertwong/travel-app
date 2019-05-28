package com.app.travelapp.ui;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.travelapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private View view;
    private SharedPreferences sharedPreferences;

    public MapFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_map, container, false);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        String startLat = sharedPreferences.getString("startLat", "");
        String startLong = sharedPreferences.getString("startLong", "");
        String endLat = sharedPreferences.getString("endLat", "");
        String endLong = sharedPreferences.getString("endLong", "");
        String originCity = sharedPreferences.getString("origin", "");
        String destinationCity = sharedPreferences.getString("destination", "");

        LatLng origin = new LatLng(Double.parseDouble(startLat), Double.parseDouble(startLong));
        LatLng destination = new LatLng(Double.parseDouble(endLat), Double.parseDouble(endLong));
        mMap.addMarker(new MarkerOptions().position(origin).title("Origin: " + originCity));
        mMap.addMarker(new MarkerOptions().position(destination).title("Destination: " + destinationCity));
        float zoomLevel = 5.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(origin, zoomLevel));
    }
}
