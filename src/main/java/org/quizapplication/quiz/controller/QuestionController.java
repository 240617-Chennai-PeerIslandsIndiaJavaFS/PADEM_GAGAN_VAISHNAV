package org.quizapplication.quiz.controller;

import org.quizapplication.quiz.models.Question;
import org.quizapplication.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question")
    public String showQuestion(Model model) {
        Question question = questionService.getRandomQuestion();
        model.addAttribute("question", question);
        return "question";
    }

    @PostMapping("/submitAnswer")
    public String submitAnswer(@RequestParam String answer, Model model) {
        int score = questionService.validateAnswer(answer);
        model.addAttribute("score", score);
        return "result";
    }
}
