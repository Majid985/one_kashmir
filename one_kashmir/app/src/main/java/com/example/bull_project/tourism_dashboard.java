package com.example.bull_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class tourism_dashboard extends AppCompatActivity {

    CardView tourist_destination , hotel_booking , other_online_booking;

//    Objects for Toggle orr navigation bar
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism_dashboard);


// ==============HOOKS================================================================
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav);
        toolbar=findViewById(R.id.toolbar);
        tourist_destination = findViewById(R.id.tourist_destination);
        hotel_booking = findViewById(R.id.hotel_booking);
        other_online_booking = findViewById(R.id.online_booking);

        //       Call for other online bookings
        other_online_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(tourism_dashboard.this, online_booking.class);
                startActivity(i);
            }
        });



//        To Call Hotels
        hotel_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(tourism_dashboard.this, hotels.class);
                startActivity(i);
            }
        });

//        TO CALL Tourist Destions cards
        tourist_destination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(tourism_dashboard.this,tourist_destination.class);
                startActivity(i);


            }
        });

//  ===================  Navigation drawer toggle button
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //        =============NAVIGATION DRAWER EVENT LISTENER==========================

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id)
                {
                    case R.id.nav_home:
                        Intent ii = new Intent(tourism_dashboard.this, Login.class);
                        startActivity(ii);
                        finish();
                        break;
                    case R.id.nav_profile:
                        Toast.makeText(tourism_dashboard.this,"WELCOME TO PROFILE",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_contact_us:
                        Intent contact_us = new Intent(tourism_dashboard.this,contact_us.class);
                        startActivity(contact_us);
                        break;
                    case R.id.nav_helpline:
                        Intent help = new Intent(tourism_dashboard.this,helpline.class);
                        startActivity(help);
                        break;
                    case R.id.nav_about_us:
                        Intent about_us = new Intent(tourism_dashboard.this,about_us.class);
                        startActivity(about_us);
                        break;
                    case R.id.nav_logout:
                        Intent i = new Intent(tourism_dashboard.this, Login.class);
                        startActivity(i);
                        finish();
                        break;
                    default:
                        return true;

                }

                return false;
            }
        });

//        =======================================================================================================tourism_dashboard






    }

}