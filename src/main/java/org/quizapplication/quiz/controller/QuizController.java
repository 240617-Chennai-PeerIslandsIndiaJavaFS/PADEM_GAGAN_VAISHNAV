package org.quizapplication.quiz.controller;

import org.quizapplication.quiz.models.Question;
import org.quizapplication.quiz.service.QuestionService;
import org.quizapplication.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/quiz")
public class QuizController {

        @Autowired
        private QuestionService questionService;

        @Autowired
        private QuizService quizService;

        @GetMapping("/question")
        public String showQuestion(Question question, @RequestParam("userId") int userId) {
                question = quizService.getRandomQuestion();
                return "question";
        }

        @PostMapping("/submitAnswer")
        public String submitAnswer(@RequestParam String answer, @RequestParam int userId, Question question) {
                int score = quizService.validateAnswer(answer, userId);
                return "result";
        }
}
