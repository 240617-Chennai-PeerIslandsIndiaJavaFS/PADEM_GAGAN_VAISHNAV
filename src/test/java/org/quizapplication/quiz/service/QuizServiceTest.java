package org.quizapplication.quiz.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.quizapplication.quiz.dao.QuestionRepository;
import org.quizapplication.quiz.dao.ScoreRepository;
import org.quizapplication.quiz.models.Question;
import org.quizapplication.quiz.models.Score;
import org.quizapplication.quiz.models.User;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class QuizServiceTest {

    @InjectMocks
    private QuizService quizService;

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private ScoreRepository scoreRepository;

    @Test
    public void testGetRandomQuestion() {
        Question question1 = new Question(1, "What is 2 + 2?", "4");
        Question question2 = new Question(2, "What is 3 + 3?", "6");
        List<Question> questions = Arrays.asList(question1, question2);
        when(questionRepository.findAll()).thenReturn(questions);
        when(questionRepository.count()).thenReturn(2L);

        Question result = quizService.getRandomQuestion();
        assertNotNull(result);
        assertTrue(questions.contains(result));
    }

    @Test
    public void testValidateAnswer_Correct() {
        Question question = new Question(1, "What is 2 + 2?", "4");
        quizService.setCurrentQuestion(question);

        Score existingScore = new Score(1, 10);
        when(scoreRepository.findByUserid(1)).thenReturn(Optional.of(existingScore));

        int score = quizService.validateAnswer("4", 1);
        assertEquals(1, score);
        verify(scoreRepository).save(existingScore);
    }

    @Test
    public void testValidateAnswer_Incorrect() {
        Question question = new Question(1, "What is 2 + 2?", "4");
        quizService.setCurrentQuestion(question);

        Score existingScore = new Score(1, 10);
        when(scoreRepository.findByUserid(1)).thenReturn(Optional.of(existingScore));

        int score = quizService.validateAnswer("5", 1);
        assertEquals(0, score);
        verify(scoreRepository).save(existingScore);
    }
}
