package com.example.readysteadybang2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ActivityReadyPvp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready_pvp);
    }

    @Override
    public void onBackPressed() {
        return;
    }
}