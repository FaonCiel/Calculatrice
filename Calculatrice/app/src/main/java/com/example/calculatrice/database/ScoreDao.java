package com.example.calculatrice.database;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.calculatrice.entity.Score;

import java.util.List;

public class ScoreDao extends BaseDao<Score>  {

    static final String INDEX_PERSONAL_NAME = "Name";
    static final String INDEX_SCORE = "Score";

    public ScoreDao(DataBaseHelper helper){
        super(helper);

    }

    @Override
    protected String getTableName() {
        return "TableauDesScores";
    }

    @Override
    protected void putValues(ContentValues values, Score entity) {
            values.put(INDEX_PERSONAL_NAME,entity.getName());
            values.put(INDEX_SCORE,entity.getScore());
    }

    @Override
    protected Score getEntity(Cursor cursor) {
        Score score = new Score();
        Integer IndexNom = cursor.getColumnIndex(INDEX_PERSONAL_NAME);
        score.setName(cursor.getString(IndexNom));
        Integer IndexScore = cursor.getColumnIndex(INDEX_SCORE);
        score.setScore(cursor.getInt(IndexScore));
        return score;
    }

    public List<Score> query(){
        return super.query(null,null,INDEX_SCORE + " DESC, " + INDEX_PERSONAL_NAME + " ASC");
    }


}
