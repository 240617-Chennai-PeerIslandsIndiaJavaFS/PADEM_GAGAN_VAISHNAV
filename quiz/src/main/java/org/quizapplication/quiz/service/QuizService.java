package org.quizapplication.quiz.service;

import org.quizapplication.quiz.dao.QuestionRepository;
import org.quizapplication.quiz.dao.ScoreRepository;
import org.quizapplication.quiz.models.Question;
import org.quizapplication.quiz.models.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ScoreRepository scoreRepository;

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

    public int validateAnswer(String answer, int userId) {
        if (currentQuestion == null) {
            throw new IllegalStateException("No question available for validation");
        }

        boolean isCorrect = currentQuestion.getCorrectanswer().equalsIgnoreCase(answer.trim());
        int score = isCorrect ? 1 : 0;
        saveOrUpdateScore(userId, score);
        return score;
    }

    private void saveOrUpdateScore(int userId, int score) {
        Optional<Score> existingScoreOpt = scoreRepository.findByUserid(userId);

        if (existingScoreOpt.isPresent()) {
            Score existingScore = existingScoreOpt.get();
            existingScore.setScore(existingScore.getScore() + score);
            scoreRepository.save(existingScore);
        } else {
            Score newScore = new Score();
            newScore.setUserid(userId);
            newScore.setScore(score);
            scoreRepository.save(newScore);
        }
    }
}
