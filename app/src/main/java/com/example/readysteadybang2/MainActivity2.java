package com.example.readysteadybang2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    public boolean isFirstActivityOpened = false;
    public boolean isSecondeActivityOpened = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void onImage1Click(View view){
        Intent intent = new Intent(this, Activity21.class);
        if (!isSecondeActivityOpened) {
            startActivity(intent);
            isFirstActivityOpened = true;
        }
    }
    public void onImage2Click(View view){
        Intent intent = new Intent(this, Activity22.class);
        if (!isFirstActivityOpened) {
            startActivity(intent);
            isSecondeActivityOpened = true;
        }

    }
}