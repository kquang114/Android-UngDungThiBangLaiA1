package com.example.admin.onthia11.question;

import java.io.Serializable;

public class Question implements Serializable {
    public int choiceID = -1;
    private int _id;
    private String question;
    private String answer_1;
    private String answer_2;
    private String answer_3;
    private String result;
    private String image;
    private int number_exam;
    private String subject;
    private  String traloi="";

    public String getTraloi() {
        return traloi;
    }

    public void setTraloi(String traloi) {
        this.traloi = traloi;
    }

    public Question(int _id, String question, String answer_1, String answer_2, String answer_3, String result,
                    String image, int number_exam, String subject, String traloi) {
        this._id = _id;
        this.question = question;
        this.answer_1 = answer_1;
        this.answer_2 = answer_2;
        this.answer_3 = answer_3;
        this.result = result;
        this.image = image;
        this.number_exam = number_exam;
        this.subject = subject;
        this.traloi = traloi;
    }

    public Question() {
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer_1() {
        return answer_1;
    }

    public void setAnswer_1(String answer_1) {
        this.answer_1 = answer_1;
    }

    public String getAnswer_2() {
        return answer_2;
    }

    public void setAnswer_2(String answer_2) {
        this.answer_2 = answer_2;
    }

    public String getAnswer_3() {
        return answer_3;
    }

    public void setAnswer_3(String answer_3) {
        this.answer_3 = answer_3;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNumber_exam() {
        return number_exam;
    }

    public void setNumber_exam(int number_exam) {
        this.number_exam = number_exam;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
