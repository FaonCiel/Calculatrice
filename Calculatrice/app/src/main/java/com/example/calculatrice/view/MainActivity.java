package com.example.calculatrice.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.calculatrice.R;
import com.example.calculatrice.view.Calcul_activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boutonCalculer = findViewById(R.id.bouton_calculer);
        Button boutonLastCompute = findViewById(R.id.bouton_2);
        boutonCalculer.setOnClickListener(view -> lanceActiviteCalculer());
        //boutonLastCompute.setOnClickListener(view -> lanceDernierCalcul() );

    }
    private void lanceActiviteCalculer() {
        Intent i = new Intent(this, Calcul_activity.class);
        startActivity(i);
    }
}