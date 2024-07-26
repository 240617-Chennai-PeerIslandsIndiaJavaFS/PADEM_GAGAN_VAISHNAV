package org.quizapplication.quiz.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "score")
public class Score {
    @Id
    private int scoreid;
    @Column(name = "userid")
    private int userid;
    @Column(name = "score")
    private int score;

    public Score(){}

    public Score(int scoreid, int userid, int score) {
        this.scoreid = scoreid;
        this.userid = userid;
        this.score = score;
    }

    public int getScoreid() {
        return scoreid;
    }

    public void setScoreid(int scoreid) {
        this.scoreid = scoreid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
