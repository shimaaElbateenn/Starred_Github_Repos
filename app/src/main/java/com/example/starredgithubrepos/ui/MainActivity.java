package com.example.starredgithubrepos.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.starredgithubrepos.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    BottomNavigationView navigationView;
    final FragmentManager fragmentManager = getSupportFragmentManager();
    final Fragment trendingFragment = new TrendingFragment();
    final Fragment settingsFragment = new SettingsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupVariables();
    }

    void setupVariables() {
        navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnItemSelectedListener(this);
        navigationView.setSelectedItemId(R.id.action_favorites);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.action_favorites:
            default:
                fragment = trendingFragment;
                break;
            case R.id.navigation_settings:
                fragment = settingsFragment;
                break;
        }
        fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
        return true;
    }

}