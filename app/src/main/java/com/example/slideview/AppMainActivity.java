package com.example.slideview;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AppMainActivity extends AppCompatActivity implements BottomNavigationView.OnItemSelectedListener {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_main);

        bottomNavigationView = findViewById(R.id.bottomNavView);
        bottomNavigationView.setOnItemSelectedListener(this);

        // 프래그먼트 초기화
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, new HomeFragment())
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;

        // 선택된 아이템에 따라 프래그먼트 선택

        if(item.getItemId()==R.id.tab_home) {
            selectedFragment = new HomeFragment();
        }
        else if(item.getItemId()==R.id.tab_ranking) {
            selectedFragment = new RankingFragment();
        }
        else if(item.getItemId()==R.id.tab_myPage) {
            selectedFragment = new MyPageFragment();
        }


        // 선택된 프래그먼트로 교체
        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, selectedFragment)
                    .commit();
            return true;
        }
        return false;
    }
}