package org.quizapplication.quiz.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "question")

public class Question {
    @Id
    private int questionid;
    @Column(name = "questiontext")
    private String questiontext;
    @Column(name = "correctanswer")
    private String correctanswer;

    public Question(){}

    public Question(int questionid, String questiontext, String correctanswer) {
        this.questionid = questionid;
        this.questiontext = questiontext;
        this.correctanswer = correctanswer;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public String getQuestiontext() {
        return questiontext;
    }

    public void setQuestiontext(String questiontext) {
        this.questiontext = questiontext;
    }

    public String getCorrectanswer() {
        return correctanswer;
    }

    public void setCorrectanswer(String correctanswer) {
        this.correctanswer = correctanswer;
    }
}
