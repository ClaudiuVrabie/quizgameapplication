package com.internship.QuizGame.controller;

import com.internship.QuizGame.model.dto.CreatePlayerDto;
import com.internship.QuizGame.model.dto.PlayerDto;
import com.internship.QuizGame.service.PlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/mvc/player")
@RequiredArgsConstructor
public class PlayerMvcController {

    private final PlayerService playerService;
    @GetMapping("viewAll")
    public String getAllPlayers(Model model){
        List<PlayerDto> patientsList = playerService.findAll();
        model.addAttribute("players", patientsList);
        return "player/viewAll";
    }
    @GetMapping("/create")
    public String createPlayerPage(Model model){
        model.addAttribute("player", CreatePlayerDto.builder().build());
        return "player/createPlayer";
    }
    @PostMapping("/submitCreatePlayerForm")
    public String submitCreatePatientForm (@Valid CreatePlayerDto createPlayerDto, BindingResult bindingResult , RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            return "validationError";
        }
        try {
            playerService.createPlayer(createPlayerDto);
        }
        catch (ResponseStatusException exception){
            return "entityExistsError";
        }
        redirectAttributes.addFlashAttribute("successMessage", "Account created successfully");
        return "redirect:/login";
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePlayerById(Model model, @PathVariable Integer id){
        playerService.deletePlayerById(id);
    }
}
