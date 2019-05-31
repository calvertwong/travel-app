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
import android.widget.TextView;

import com.app.travelapp.R;
import com.app.travelapp.authentication.login.LoginFragment;
import com.app.travelapp.payment.PaymentFragment;
import com.app.travelapp.route.home.HomeFragment;
import com.app.travelapp.authentication.forgotpassword.ForgotPasswordFragment;
import com.app.travelapp.seatselection.SeatFragment;
import com.app.travelapp.utils.InformationFragment;
import com.app.travelapp.utils.PaymentEmailFragment;
import com.app.travelapp.utils.SummaryFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        sharedPreferences = getSharedPreferences("userPre", Context.MODE_PRIVATE);

        if (sharedPreferences.getString("id", "").equals("")) {
            lockDrawer();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginFragment()).commit();
        } else {
            unlockDrawer();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            setNavHeaderDetails();
        }
    }

    public void setNavHeaderDetails() {
        TextView fullNameTextView = navigationView.getHeaderView(0).findViewById(R.id.full_name_textview);
        TextView userEmailTextView = navigationView.getHeaderView(0).findViewById(R.id.user_email_textview);

        String fullName = sharedPreferences.getString("firstname", "First") + " " + sharedPreferences.getString("lastname", "Last");
        String userEmail = sharedPreferences.getString("email", "Email");

        fullNameTextView.setText(fullName);
        userEmailTextView.setText(userEmail);
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
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).addToBackStack(null).commit();
        }  else if (id == R.id.nav_forgot_password) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ForgotPasswordFragment()).commit();

        } else if(id == R.id.nav_information){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new InformationFragment()).commit();
        }

        else if (id == R.id.nav_sign_out) {
            editor = sharedPreferences.edit();
            editor.clear().apply();
            lockDrawer();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginFragment()).addToBackStack(null).commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }

    public void lockDrawer() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }


    public void unlockDrawer() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    private void init() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }
}
