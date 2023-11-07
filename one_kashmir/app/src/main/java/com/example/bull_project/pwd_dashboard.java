package com.example.bull_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class pwd_dashboard extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwd_dashboard);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav);
        toolbar=findViewById(R.id.toolbar);

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
                        Intent i = new Intent(pwd_dashboard.this, dashboard.class);
                        startActivity(i);
                        finish();
                        break;
                    case R.id.nav_profile:
                        Toast.makeText(pwd_dashboard.this,"WELCOME TO PROFILE",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_contact_us:
                        Intent contact_us = new Intent(pwd_dashboard.this,contact_us.class);
                        startActivity(contact_us);
                        break;
                    case R.id.nav_helpline:
                        Intent help = new Intent(pwd_dashboard.this,helpline.class);
                        startActivity(help);
                        break;
                    case R.id.nav_about_us:
                        Intent about_us = new Intent(pwd_dashboard.this,about_us.class);
                        startActivity(about_us);
                        break;
                    case R.id.nav_logout:
                        Intent ii = new Intent(pwd_dashboard.this, Login.class);
                        startActivity(ii);
                        finish();
                        break;
                    default:
                        return true;

                }

                return false;
            }
        });

//        ================================================================================================================




    }
}