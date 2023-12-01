package com.example.readysteadybang2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.media.MediaPlayer;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    private TextView textReady;
    public boolean isFirstActivityOpened = false;
    public boolean isSecondeActivityOpened = false;
    public boolean tooSoon = true;
    private MediaPlayer readyVoice;
    private MediaPlayer steadyVoice;
    private MediaPlayer bangVoice;
    private MediaPlayer shoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        readyVoice = MediaPlayer.create(this, R.raw.readyvoice);
        steadyVoice = MediaPlayer.create(this, R.raw.steadyvoice);
        bangVoice = MediaPlayer.create(this, R.raw.bangvoice);
        shoot = MediaPlayer.create(this, R.raw.coupsfeu);

        textReady = findViewById(R.id.textReady);

        long delayMillis = 1500;
        int randomDelay = generateRandomDelay();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Affichage du texte après le délai
                readyVoice.start();
                textReady.setText("READY");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Disparition du premier texte
                        textReady.setText("");

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Affichage du deuxième texte
                                steadyVoice.start();
                                textReady.setText("STEADY");

                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        // Affichage du deuxième texte
                                        textReady.setText("");
                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                // Affichage du deuxième texte
                                                bangVoice.start();
                                                textReady.setText("BANG !");
                                                tooSoon = false;
                                            }
                                        }, randomDelay);
                                    }
                                }, delayMillis);
                            }
                        }, delayMillis);
                    }
                }, delayMillis);
            }
        }, delayMillis);
    }

    @Override
    public void onBackPressed() {
        return;
    }

    public void onImage1Click(View view) {
        shoot.start();
        if (tooSoon) {
            Intent intent = new Intent(this, Activity21.class);
            if (!isSecondeActivityOpened) {
                startActivity(intent);
                isFirstActivityOpened = true;
            }
        }
        else{
            Intent intent = new Intent(this, Activity22.class);
            if (!isSecondeActivityOpened) {
                startActivity(intent);
                isFirstActivityOpened = true;
            }
        }
    }

    public void onImage2Click(View view) {
        shoot.start();
        if (tooSoon) {
            Intent intent = new Intent(this, Activity22.class);
            if (!isFirstActivityOpened) {
                startActivity(intent);
                isSecondeActivityOpened = true;
            }
        }
        else{
            Intent intent = new Intent(this, Activity21.class);
            if (!isFirstActivityOpened) {
                startActivity(intent);
                isSecondeActivityOpened = true;
            }
        }
    }

    private int generateRandomDelay() {
        // Créer une instance de la classe Random
        Random random = new Random();

        // Générer un nombre aléatoire entre 0 et 5000
        return random.nextInt(5000);
    }

}
