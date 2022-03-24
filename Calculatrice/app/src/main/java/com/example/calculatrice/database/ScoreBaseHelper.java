package com.example.calculatrice.database;

import android.content.Context;
public class ScoreBaseHelper extends DataBaseHelper{

    public ScoreBaseHelper(Context context){
        super(context, "TableauDesScores",1);
    }

    @Override
    protected String getCreationSql(){
        return "CREATE TABLE IF NOT EXISTS TableauDesScores (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                ScoreDao.INDEX_PERSONAL_NAME + " VARCHAR(50) NOT NULL," +
                ScoreDao.INDEX_SCORE + " INTEGER NOT NULL" +
                ")";
    }

    @Override
    protected String getDeleteSql() {
        return null;
    }
}

