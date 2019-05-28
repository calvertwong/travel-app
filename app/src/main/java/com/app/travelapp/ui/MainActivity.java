package com.app.travelapp.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.app.travelapp.R;
import com.app.travelapp.authentication.login.LoginFragment;
import com.app.travelapp.authentication.register.RegisterFragment;
import com.app.travelapp.payment.PaymentFragment;
import com.app.travelapp.route.home.HomeFragment;
import com.app.travelapp.authentication.forgotpassword.ForgotPasswordFragment;
import com.app.travelapp.seatselection.SeatFragment;
import com.app.travelapp.seat.ShowSeatDetailsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        sharedPreferences = getSharedPreferences("userPre", Context.MODE_PRIVATE);

        if (sharedPreferences.getString("id", "").equals("")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginFragment()).commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new BusDetailFragment()).addToBackStack(null).commit();
        } else if (id == R.id.nav_gallery) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShowSeatDetailsFragment()).addToBackStack(null).commit();

        } else if (id == R.id.nav_slideshow) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PaymentFragment()).commit();

        } else if (id == R.id.nav_tools) {
            //temp
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ForgotPasswordFragment()).commit();

        } else if (id == R.id.nav_share) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginFragment()).commit();
        } else if (id == R.id.nav_send) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SeatFragment()).addToBackStack(null).commit();
        } else if (id == R.id.nav_sign_out) {
            editor = sharedPreferences.edit();
            editor.clear().apply();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginFragment()).addToBackStack(null).commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }

    private void init() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }
}
