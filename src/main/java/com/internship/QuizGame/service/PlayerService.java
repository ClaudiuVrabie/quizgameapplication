package com.internship.QuizGame.service;

import com.internship.QuizGame.exception.BusinessException;
import com.internship.QuizGame.model.Player;
import com.internship.QuizGame.model.dto.CreatePlayerDto;
import com.internship.QuizGame.model.dto.PlayerDto;
import com.internship.QuizGame.model.dto.UpdatePlayerDto;
import com.internship.QuizGame.repository.PlayerRepository;
import com.internship.QuizGame.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;


    public List<PlayerDto> findAll() {
        return playerRepository.findAll()
                .stream()
                .map(PlayerDto::new).toList();
    }
    public PlayerDto findById(Integer id) {
       Player player = playerRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Player with " + id + " not found"));
       return new PlayerDto(player);
    }
    @Transactional
    public Integer createPlayer(CreatePlayerDto createPlayerDto) {
        userRepository.findByUserName(createPlayerDto.getUserName()).ifPresent(user -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Player already exists!");
                }
        );

        Player player = Player.builder()
                .userName(createPlayerDto.getUserName())
//                .password(passwordEncoder.encode(createPlayerDto.getPassword()))
                .name(createPlayerDto.getName())
                .age(createPlayerDto.getAge())
                .isActive(true)
                .roles("ROLE_PLAYER")
                .build();
        return userRepository.save(player).getId();
    }
    public void updatePlayer(UpdatePlayerDto updatePlayerDto) {
        Player player = playerRepository
                .findById(updatePlayerDto.getId())
                .orElseThrow(() -> new BusinessException(HttpStatus.BAD_REQUEST, "Player with id " + updatePlayerDto.getId() + " not found"));

        if (updatePlayerDto.getAge() != null) {
            player.setAge(updatePlayerDto.getAge());
        }
        playerRepository.save(player);
    }
    public Player findByUsername(String username) {
        return playerRepository.findByUserName(username)
                .orElseThrow(() -> new EntityNotFoundException("Player not found"));
    }
    @Transactional
    public void deletePlayerById(Integer id) {
        Player player = playerRepository.findById(id).orElseThrow(
                () -> new BusinessException(HttpStatus.NOT_FOUND, "Invalid player id"));
        playerRepository.delete(player);
    }
}
