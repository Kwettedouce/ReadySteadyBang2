package com.example.readysteadybang2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity4 extends AppCompatActivity {

    private Button buttonMenu4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        buttonMenu4 = (Button) findViewById(R.id.buttonMenu4);

        buttonMenu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu4();
            }
        });
    }

    @Override
    public void onBackPressed() {
        return;
    }

    public void openMenu4(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}