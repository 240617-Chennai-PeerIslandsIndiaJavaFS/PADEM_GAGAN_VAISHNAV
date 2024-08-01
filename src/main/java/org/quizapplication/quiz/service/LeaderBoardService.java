package org.quizapplication.quiz.service;

import org.quizapplication.quiz.dao.ScoreRepository;
import org.quizapplication.quiz.models.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeaderBoardService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getTop3Scores() {
        return scoreRepository.findTop3ByOrderByScoreDesc();
    }

    public List<Score> getTopScores() {
        return scoreRepository.findAll();
    }
}
