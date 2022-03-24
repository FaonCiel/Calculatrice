package com.example.calculatrice.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.calculatrice.R;
import com.example.calculatrice.database.ScoreBaseHelper;
import com.example.calculatrice.database.ScoreDao;
import com.example.calculatrice.entity.Score;
import com.example.calculatrice.service.ScoreService;

import java.util.List;


public class Scoreboard extends AppCompatActivity {
    List<Score> ListScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        TextView textViewScore = findViewById(R.id.ScoreTextView);

        ScoreService Score = new ScoreService(new ScoreDao(new ScoreBaseHelper(this)));
        ListScore = Score.getScore();
        textViewScore.setText(ListScore.get(0).toString());
    }


}