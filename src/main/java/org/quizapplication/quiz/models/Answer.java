package org.quizapplication.quiz.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "answer")

public class Answer {
    @Id
    private int id;
    @Column(name = "questionid")
    private int questionid;
    @Column(name = "answertext")
    private String answertext;

    public Answer(){}

    public Answer(int id, int questionid, String answertext) {
        this.id = id;
        this.questionid = questionid;
        this.answertext = answertext;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public String getAnswertext() {
        return answertext;
    }

    public void setAnswertext(String answertext) {
        this.answertext = answertext;
    }
}
