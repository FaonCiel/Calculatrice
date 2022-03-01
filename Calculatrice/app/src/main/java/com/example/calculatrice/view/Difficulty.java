package com.example.calculatrice.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.calculatrice.R;

public class Difficulty extends AppCompatActivity {



    private int difficulty =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificulty);
        Button easy = findViewById(R.id.button_easy);
        easy.setOnClickListener(view -> setdifficulty(0));

        Button medium = findViewById(R.id.button_medium);
        medium.setOnClickListener(view -> setdifficulty(1));

        Button hard = findViewById(R.id.button_hard);
        hard.setOnClickListener(view -> setdifficulty(2));

        Button asian = findViewById(R.id.button_Asian);
        asian.setOnClickListener(view -> setdifficulty(3));

    }

    private void setdifficulty(int nb){

            difficulty = nb;
    }
    public int getDifficulty() {
        return difficulty;
    }
}