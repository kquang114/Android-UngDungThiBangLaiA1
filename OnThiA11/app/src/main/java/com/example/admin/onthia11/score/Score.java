package com.example.admin.onthia11.score;

public class Score {
    private int _id;
    private String name;
    private String nghe;
    private int score;
    private String date;

    public Score(String name, String nghe, int score) {
        this.name = name;
        this.nghe = nghe;
        this.score = score;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNghe() {
        return nghe;
    }

    public void setNghe(String nghe) {
        this.nghe = nghe;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

