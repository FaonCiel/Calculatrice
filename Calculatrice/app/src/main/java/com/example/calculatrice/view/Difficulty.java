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
        easy.setOnClickListener(view -> lanceCalcul(0));

        Button medium = findViewById(R.id.button_medium);
        medium.setOnClickListener(view -> lanceCalcul(1));

        Button hard = findViewById(R.id.button_hard);
        hard.setOnClickListener(view -> lanceCalcul(2));

        Button asian = findViewById(R.id.button_Asian);
        asian.setOnClickListener(view -> lanceCalcul(3));

    }

    private void lanceCalcul(int nb){
        Intent i = new Intent(this, End_Game.class);
        i.putExtra("idDif",nb);
    }


}