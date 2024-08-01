package org.quizapplication.quiz.controller;

import org.quizapplication.quiz.models.Score;
import org.quizapplication.quiz.service.LeaderBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/leaderboard")
public class LeaderBoardController {
    @Autowired
    private LeaderBoardService leaderBoardService;

    @GetMapping("/top")
    public List<Score> getTop3Scores() {
        return leaderBoardService.getTop3Scores();
    }
    @GetMapping
    public List<Score> getTopScores(){
        return leaderBoardService.getTopScores();
    }
}
