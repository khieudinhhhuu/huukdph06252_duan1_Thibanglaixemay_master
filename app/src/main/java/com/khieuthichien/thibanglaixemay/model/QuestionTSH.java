package com.khieuthichien.thibanglaixemay.model;

import java.io.Serializable;

public class QuestionTSH implements Serializable{
    private int _id;
    private String question2;
    private String answer_a;
    private String answer_b;
    private String answer_c;
    private String answer_d;
    private String result;
    private int num_exam;
    private String image;
    private String subject;
    private String traloi = "";
    public int choiceID= -1; //hỗ trợ check Id của radiogroup

    public QuestionTSH(int _id, String question2, String answer_a, String answer_b, String answer_c, String answer_d, String result, int num_exam, String image, String subject) {
        this._id = _id;
        this.question2 = question2;
        this.answer_a = answer_a;
        this.answer_b = answer_b;
        this.answer_c = answer_c;
        this.answer_d = answer_d;
        this.result = result;
        this.num_exam = num_exam;
        this.image = image;
        this.subject = subject;
    }

    public QuestionTSH(int _id, String question2, String answer_a, String answer_b, String answer_c, String answer_d, String result, int num_exam, String image, String subject, String traloi) {
        this._id = _id;
        this.question2 = question2;
        this.answer_a = answer_a;
        this.answer_b = answer_b;
        this.answer_c = answer_c;
        this.answer_d = answer_d;
        this.result = result;
        this.num_exam = num_exam;
        this.image = image;
        this.subject = subject;
        this.traloi = traloi;
    }

    public QuestionTSH() {
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getAnswer_a() {
        return answer_a;
    }

    public void setAnswer_a(String answer_a) {
        this.answer_a = answer_a;
    }

    public String getAnswer_b() {
        return answer_b;
    }

    public void setAnswer_b(String answer_b) {
        this.answer_b = answer_b;
    }

    public String getAnswer_c() {
        return answer_c;
    }

    public void setAnswer_c(String answer_c) {
        this.answer_c = answer_c;
    }

    public String getAnswer_d() {
        return answer_d;
    }

    public void setAnswer_d(String answer_d) {
        this.answer_d = answer_d;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getNum_exam() {
        return num_exam;
    }

    public void setNum_exam(int num_exam) {
        this.num_exam = num_exam;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTraloi() {
        return traloi;
    }

    public void setTraloi(String traloi) {
        this.traloi = traloi;
    }
}
