package org.quizapplication.quiz.service;

import org.quizapplication.quiz.dao.QuestionRepository;
import org.quizapplication.quiz.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    private Question currentQuestion;

    public Question getRandomQuestion() {
        long count = questionRepository.count();
        if (count == 0) {
            return null;
        }
        int randomIndex = new Random().nextInt((int) count);
        List<Question> questions = questionRepository.findAll();
        currentQuestion = questions.get(randomIndex);
        return currentQuestion;
    }

    public void setCurrentQuestion(Question question) {
        this.currentQuestion = question;
    }

    public int validateAnswer(String answer) {
        if (currentQuestion == null) {
            throw new IllegalStateException("No question available for validation");
        }
        boolean isCorrect = currentQuestion.getCorrectanswer().equalsIgnoreCase(answer.trim());
        return isCorrect ? 1 : 0;
    }
}
