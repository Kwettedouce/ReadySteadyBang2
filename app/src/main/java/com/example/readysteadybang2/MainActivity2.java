package com.example.readysteadybang2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView textReady;
    public boolean isFirstActivityOpened = false;
    public boolean isSecondeActivityOpened = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textReady = findViewById(R.id.textReady);

        long delayMillis = 3000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Affichage du texte après le délai
                textReady.setText("READY");
            }
        }, delayMillis);
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