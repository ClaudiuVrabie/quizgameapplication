package com.internship.QuizGame.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HomePageController {

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("message", "Quiz Game");
        return "index";
    }












    //    @GetMapping("/login")
//    public String login(Model model, @RequestParam(value = "accountCreated", required = false) boolean accountCreated){
//        if (accountCreated) {
//            model.addAttribute("successMessage", "Account created successfully!");
//        }
//        return "login";
//    }
//    @GetMapping("/default")
//    public String successPage(HttpServletRequest request){
//        if(request.isUserInRole("ADMIN")){
//            return "redirect:/";
//        } else if (request.isUserInRole("PLAYER")) {
//            return "redirect:/indexPlayer";
//        } else
//            return "redirect:/indexUser";
//
//    }
}
