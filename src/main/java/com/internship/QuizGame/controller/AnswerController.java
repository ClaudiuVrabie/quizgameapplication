package com.internship.QuizGame.controller;

import com.internship.QuizGame.model.Answer;
import com.internship.QuizGame.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {
    private AnswerService answerService;

    public AnswerController(AnswerService answerService){
        this.answerService = answerService;
    }

    @GetMapping("/firstAnswerValidation")
    public String correctAnswer(Model model){
        model.addAttribute("goodAnswer", "firstGoodAnswer");
        return "answer/firstAnswerValidation";
    }
    @GetMapping("/answerError")
    public String badAnswer(Model model){
        model.addAttribute("badAnswer", "firstBadAnswer");
        return "answer/answerError";
    }
    @GetMapping("/finalPage")
    public String getFinalPage(Model model){
        model.addAttribute("finalPage", "page");
        return "answer/finalPage";
    }


//    @GetMapping
//    public List<Answer> findAll(){
//        return answerService.findAll();
//    }
//    @PostMapping
//    public void createAnswer(Object answer){
//
//    }
}
