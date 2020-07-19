package com.example.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SearchActivity extends AppCompatActivity {

    final String TAG = "SearchActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        BottomNavigationInit();
    }

    private void BottomNavigationInit() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
//       처음에 선택되는 Item 설정.
        bottomNavigationView.setSelectedItemId(R.id.bottomItemSearch);
//      Item들을 누르면 다른 Activity로 넘어가도록 만들었다.
//      fragment 를 사용해서 넘어가는 것처럼 보이게하기위해서 overridePendingTransition 메소드를 사용했다.
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottomItemHome:
                        Log.d(TAG, "bottomItemSearch");
                        Intent homeIntent = new Intent(getApplicationContext(), Main.class);
                        startActivity(homeIntent);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.bottomItemSearch:
                        Log.d(TAG, "bottomItemSearch");
                        return true;
                    case R.id.bottomItemAdd:
                        Log.d(TAG, "bottomItemAdd");
                        Intent addIntent  = new Intent(getApplicationContext(), AddActivity.class);
                        startActivity(addIntent);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.bottomItemLike:
                        Log.d(TAG, "bottomItemLike");
                        Intent likeIntent  = new Intent(getApplicationContext(), LikeActivity.class);
                        startActivity(likeIntent);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.bottomItemMyAccount:
                        Log.d(TAG, "bottomItemMyAccount");
                        Intent accountIntent  = new Intent(getApplicationContext(), AccountActivity.class);
                        startActivity(accountIntent);
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}