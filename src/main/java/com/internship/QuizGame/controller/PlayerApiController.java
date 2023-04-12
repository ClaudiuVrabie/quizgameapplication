package com.internship.QuizGame.controller;

import com.internship.QuizGame.model.dto.CreatePlayerDto;
import com.internship.QuizGame.model.dto.PlayerDto;
import com.internship.QuizGame.model.dto.UpdatePlayerDto;
import com.internship.QuizGame.service.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/player")
public class PlayerApiController {
    private final PlayerService playerService;
    public PlayerApiController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @PostMapping()
    public void createPlayer(CreatePlayerDto createPlayerDto){
        playerService.createPlayer(createPlayerDto);
    }

    @GetMapping("{id}")
    public PlayerDto findById(@PathVariable("id") Integer id) {
       return playerService.findById(id);
    }


    @GetMapping
    @Operation(description = "get all players")
    public List<PlayerDto> findAll(){
        return playerService.findAll();
    }


    @PostMapping("/create")
    @Operation(summary = "This is for creating players", description = "This is the long description",
            responses = {@ApiResponse(responseCode = "201", description = "All went well"),
                    @ApiResponse(responseCode = "400", description = "Some field is invalid or missing")}
    )
    public ResponseEntity createUser(@Valid @RequestBody CreatePlayerDto createPlayerDto){
        return ResponseEntity.status(201).body(Map.of("Id", playerService.createPlayer(createPlayerDto)));
    }
    @PatchMapping
    public void updatePlayer(@RequestBody @Valid UpdatePlayerDto updatePlayerDto){
        playerService.updatePlayer(updatePlayerDto);
    }


}
