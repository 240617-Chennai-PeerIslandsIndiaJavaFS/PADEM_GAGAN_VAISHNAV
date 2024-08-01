package org.quizapplication.quiz.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.quizapplication.quiz.dao.ScoreRepository;
import org.quizapplication.quiz.models.Score;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LeaderBoardServiceTest {

    @InjectMocks
    private LeaderBoardService leaderBoardService;

    @Mock
    private ScoreRepository scoreRepository;

    @Test
    public void testGetTop3Scores() {
        List<Score> top3Scores = Arrays.asList(
                new Score(1, 100),
                new Score(2, 90),
                new Score(3, 80)
        );
        when(scoreRepository.findTop3ByOrderByScoreDesc()).thenReturn(top3Scores);

        List<Score> result = leaderBoardService.getTop3Scores();
        assertEquals(3, result.size());
        assertEquals(top3Scores, result);
    }

    @Test
    public void testGetTopScores() {
        List<Score> allScores = Arrays.asList(
                new Score(1, 100),
                new Score(2, 90)
        );
        when(scoreRepository.findAll()).thenReturn(allScores);

        List<Score> result = leaderBoardService.getTopScores();
        assertEquals(2, result.size());
        assertEquals(allScores, result);
    }
}
