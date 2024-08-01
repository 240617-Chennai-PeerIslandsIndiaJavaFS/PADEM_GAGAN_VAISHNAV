package org.quizapplication.quiz.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.quizapplication.quiz.dao.QuestionRepository;
import org.quizapplication.quiz.models.Question;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceTest {

    @InjectMocks
    private QuestionService questionService;

    @Mock
    private QuestionRepository questionRepository;

    @Test
    public void testGetRandomQuestion() {
        Question question1 = new Question(1, "What is 2 + 2?", "4");
        Question question2 = new Question(2, "What is 3 + 3?", "6");
        List<Question> questions = Arrays.asList(question1, question2);
        when(questionRepository.findAll()).thenReturn(questions);
        when(questionRepository.count()).thenReturn(2L);

        Question result = questionService.getRandomQuestion();
        assertNotNull(result);
        assertTrue(questions.contains(result));
    }

    @Test
    public void testValidateAnswer_Correct() {
        Question question = new Question(1, "What is 2 + 2?", "4");
        questionService.setCurrentQuestion(question);

        int score = questionService.validateAnswer("4");
        assertEquals(1, score);
    }

    @Test
    public void testValidateAnswer_Incorrect() {
        Question question = new Question(1, "What is 2 + 2?", "4");
        questionService.setCurrentQuestion(question);

        int score = questionService.validateAnswer("5");
        assertEquals(0, score);
    }

    @Test
    public void testValidateAnswer_NoQuestion() {
        assertThrows(IllegalStateException.class, () -> questionService.validateAnswer("4"));
    }
}
