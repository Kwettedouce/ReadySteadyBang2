package com.example.readysteadybang2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.util.Random;

public class Activity3 extends AppCompatActivity {

    private TextView textReady;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        textReady = findViewById(R.id.textReady);

        long delayMillis = 1500;
        long delay2Millis = 10;
        int randomDelay = generateRandomDelay();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Affichage du texte après le délai
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
                                                textReady.setText("BANG !");
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

    private int generateRandomDelay() {
        // Créer une instance de la classe Random
        Random random = new Random();

        // Générer un nombre aléatoire entre 0 et 5000
        return random.nextInt(5000);
    }
}