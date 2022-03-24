package com.example.calculatrice.service;

import com.example.calculatrice.database.ScoreDao;
import com.example.calculatrice.entity.Score;

import java.util.List;

public class ScoreService {
    private ScoreDao scoreDao;


    public ScoreService(ScoreDao scoreDao) {
        this.scoreDao = scoreDao;
    }

   public void storeScoreInDatabase(Score score){
        scoreDao.create(score);
   }

  public List<Score> getScore(){
        return  scoreDao.query();
  }

}
