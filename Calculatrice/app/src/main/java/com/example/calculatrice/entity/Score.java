package com.example.calculatrice.entity;

public class Score extends BaseEntity {
    String Name;
    Integer Score;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getScore() {
        return Score;
    }

    public void setScore(Integer score) {
        Score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "Name='" + Name + '\'' +
                ", Score=" + Score +
                '}';
    }
}
