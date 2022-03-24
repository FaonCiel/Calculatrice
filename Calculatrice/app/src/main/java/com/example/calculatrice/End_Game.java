package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculatrice.database.ScoreBaseHelper;
import com.example.calculatrice.database.ScoreDao;
import com.example.calculatrice.entity.Score;
import com.example.calculatrice.service.ScoreService;
import com.example.calculatrice.view.Calcul_activity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class End_Game extends AppCompatActivity {
    private TextView Score;
    private ScoreService scoreService = new ScoreService(new ScoreDao(new ScoreBaseHelper(this)));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        Score = findViewById(R.id.Score);
        RecupScore();
        Button Sauvegarder = findViewById(R.id.Sauvegarder);

        Sauvegarder.setOnClickListener(view -> Valider());

    }

    public int RecupScore() {
        int mealId = 0;
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            mealId = bundle.getInt("Score");
        }
        Score.setText("Score " +mealId);

        return mealId;
    }
    public void Valider() {
        TextInputEditText textInputLayout = findViewById(R.id.TextInputPseudo);
        String text = textInputLayout.getText().toString().trim();
        Score score = new Score();
        score.setName(text);
        score.setScore(RecupScore());
        scoreService.storeScoreInDatabase(score);

        finish();

        //Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }


}