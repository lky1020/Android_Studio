package com.example.mark1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeMainActivity extends AppCompatActivity {

    final Fragment homeFragment = new Home();
    final Fragment profileFragment = new Profile();
    final Fragment newsFragment = new News();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        fm.beginTransaction().add(R.id.nav_fragment, newsFragment, "3").hide(newsFragment).commit();
        fm.beginTransaction().add(R.id.nav_fragment, profileFragment, "2").hide(profileFragment).commit();
        fm.beginTransaction().add(R.id.nav_fragment, homeFragment, "1").commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch(item.getItemId()){
                case R.id.nav_home:
                    fm.beginTransaction().hide(active).show(homeFragment).commit();
                    active = homeFragment;
                    return true;

                case R.id.nav_profile:
                    fm.beginTransaction().hide(active).show(profileFragment).commit();
                    active = profileFragment;
                    return true;

                case R.id.nav_news:
                    fm.beginTransaction().hide(active).show(newsFragment).commit();
                    active = newsFragment;
                    return true;

            }

            return false;
        }
    };
}
