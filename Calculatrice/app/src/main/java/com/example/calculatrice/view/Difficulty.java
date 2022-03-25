package com.example.calculatrice.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.calculatrice.R;

public class Difficulty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        Button easy = findViewById(R.id.button_easy);
        easy.setOnClickListener(view -> lanceCalcul(1));

        Button medium = findViewById(R.id.button_medium);
        medium.setOnClickListener(view -> lanceCalcul(2));

        Button hard = findViewById(R.id.button_hard);
        hard.setOnClickListener(view -> lanceCalcul(3));

        Button asian = findViewById(R.id.button_Asian);
        asian.setOnClickListener(view -> lanceCalcul(4));

    }
    private void lanceCalcul(int difficulte) {
        Intent intent = new Intent(this, Calcul_activity.class);
        intent.putExtra("difficulte", difficulte);
        startActivity(intent);
        finish();
    }



}