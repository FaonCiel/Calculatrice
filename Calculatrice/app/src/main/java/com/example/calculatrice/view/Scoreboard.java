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
    TextView[] TextViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        TextViewList = new TextView[10];

        TextViewList[0] = findViewById(R.id.ScoreTextView);
        TextViewList[1] = findViewById(R.id.ScoreTextView1);
        TextViewList[2] = findViewById(R.id.ScoreTextView2);
        TextViewList[3] = findViewById(R.id.ScoreTextView3);
        TextViewList[4] = findViewById(R.id.ScoreTextView4);
        TextViewList[5] = findViewById(R.id.ScoreTextView5);
        TextViewList[6] = findViewById(R.id.ScoreTextView6);
        TextViewList[7] = findViewById(R.id.ScoreTextView7);
        TextViewList[8] = findViewById(R.id.ScoreTextView8);
        TextViewList[9] = findViewById(R.id.ScoreTextView9);

        ScoreService Score = new ScoreService(new ScoreDao(new ScoreBaseHelper(this)));
        ListScore = Score.getScore();

        int i;
        for (i = 0; i < ListScore.size(); i++) {
            TextViewList[i].setText(ListScore.get(i).toString());
            if (i == 10) {
                break;
            }
        }
        if (i < 10) {
            for (int j = i; j < 10; j++) {
                TextViewList[j].setText(" ");
            }
        }


    }
}