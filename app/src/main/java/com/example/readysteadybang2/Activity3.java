package com.example.readysteadybang2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.media.MediaPlayer;

import java.util.Random;

public class Activity3 extends AppCompatActivity {

    private TextView textReadybis;
    public boolean tooSoon = true;
    public boolean shotBot = false;
    private MediaPlayer readyVoice;
    private MediaPlayer steadyVoice;
    private MediaPlayer bangVoice;
    private MediaPlayer shoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        readyVoice = MediaPlayer.create(this, R.raw.readyvoice);
        steadyVoice = MediaPlayer.create(this, R.raw.steadyvoice);
        bangVoice = MediaPlayer.create(this, R.raw.bangvoice);
        shoot = MediaPlayer.create(this, R.raw.coupsfeu);

        textReadybis = findViewById(R.id.textReadybis);

        long delayMillisbis = 1500;
        long delay2Millisbis = 10;
        int randomDelaybis = generateRandomDelay();
        int randomDelayBot = generateRandomDelayBot();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Affichage du texte après le délai
                readyVoice.start();
                textReadybis.setText("READY");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Disparition du premier texte
                        textReadybis.setText("");

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Affichage du deuxième texte
                                steadyVoice.start();
                                textReadybis.setText("STEADY");

                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        // Affichage du deuxième texte
                                        textReadybis.setText("");
                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                // Affichage du deuxième texte
                                                bangVoice.start();
                                                textReadybis.setText("BANG !");
                                                tooSoon = false;

                                                new Handler().postDelayed(new Runnable() {
                                                    @Override
                                                    public void run(){
                                                        shotBot = true;
                                                    }
                                                }, randomDelayBot);
                                            }
                                        }, randomDelaybis);
                                    }
                                }, delayMillisbis);
                            }
                        }, delayMillisbis);
                    }
                }, delayMillisbis);
            }
        }, delayMillisbis);
    }

    @Override
    public void onBackPressed() {
        return;
    }

    private int generateRandomDelay() {
        // Créer une instance de la classe Random
        Random random = new Random();

        // Générer un nombre aléatoire entre 0 et 5000
        return random.nextInt(5000);
    }

    private int generateRandomDelayBot() {
        // Créer une instance de la classe Random
        Random random = new Random();

        // Générer un nombre aléatoire entre 0 et 1100
        return random.nextInt(1100);
    }

    public void onImageClickbis(View view) {
        shoot.start();
        if (tooSoon || shotBot) {
            Intent intent = new Intent(this, Activity12.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, Activity11.class);
            startActivity(intent);
        }
    }
}