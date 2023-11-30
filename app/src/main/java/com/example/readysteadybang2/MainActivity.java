package com.example.readysteadybang2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button buttonPvP;
    private Button buttonPvE;
    private Button buttonRules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPvP = (Button) findViewById(R.id.buttonPvP);
        buttonPvE = (Button) findViewById(R.id.buttonPvE);
        buttonRules = (Button) findViewById(R.id.buttonRules);
        buttonPvP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityPvP();
            }
        });
        buttonPvE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityPvE();
            }
        });
        buttonRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityRules();
            }
        });
    }

    @Override
    public void onBackPressed() {
        return;
    }

    public void openActivityPvP(){
        Intent intent = new Intent(this, ActivityReadyPvp.class);
        startActivity(intent);
    }
    public void openActivityPvE(){
        Intent intent = new Intent(this, ActivityReadyPve.class);
        startActivity(intent);
    }
    public void openActivityRules(){
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }
}