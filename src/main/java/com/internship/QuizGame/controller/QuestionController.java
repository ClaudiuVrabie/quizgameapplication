package com.internship.QuizGame.controller;

import com.internship.QuizGame.model.Question;
import com.internship.QuizGame.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {

    private QuestionService questionService;

    @GetMapping("/viewFirstQuestion")
    public String viewFirstQuestionPage(Model model) {
        model.addAttribute("message", "firstQuestion");
        return "question/viewFirstQuestion";
    }

    @GetMapping("/viewSecondQuestion")
    public String viewSecondQuestionPage(Model model) {
        model.addAttribute("secondMessage", "secondQuestion");
        return "question/viewSecondQuestion";
    }
    @GetMapping("/viewThirdQuestion")
    public String viewThirdQuestionPage(Model model) {
        model.addAttribute("thirdMessage", "thirdQuestion");
        return "question/viewThirdQuestion";
    }
    @GetMapping("/viewFourthQuestion")
    public String viewFourthQuestionPage(Model model) {
        model.addAttribute("fourthMessage", "fourthQuestion");
        return "question/viewFourthQuestion";
    }
    @GetMapping("/viewFifthQuestion")
    public String viewFifthQuestionPage(Model model) {
        model.addAttribute("fifthMessage", "fifthQuestion");
        return "question/viewFifthQuestion";
    }

//    public QuestionController(QuestionService questionService){
//        this.questionService = questionService;
//    }
//    @GetMapping
//    public List<Question> findAll(){
//        return questionService.findAll();
//    }
//
//
//    @PostMapping
//    public void createQuestion(Object question){
//
//    }

}