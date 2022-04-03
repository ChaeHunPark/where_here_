package com.tutorial2.where_here;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main_where extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    Fragment fragment_map;
    Fragment fragment_Reco;
    Fragment fragment_Info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_where);

        fragment_map = new Fragment_map();
        fragment_Reco = new Fragment_Reco();
        fragment_Info = new Fragment_Info();


        bottomNavigationView = findViewById(R.id.bottomNav);

        //처음 화면 fragment_map로 나오게 설정
        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_map).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView;

        bottomNavigationView = findViewById(R.id.bottomNav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //Log.i(TAG, "바텀 네비게이션 클릭");

                switch(item.getItemId()){
                    case R.id.navi_map:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_map).commitAllowingStateLoss();
                        return true;

                    case R.id.navi_reco:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_Reco).commitAllowingStateLoss();
                        return true;

                    case R.id.navi_info:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_Info).commitAllowingStateLoss();
                        return true;

                }
                return true;
            }
        });
    }
}