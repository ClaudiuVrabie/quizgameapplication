package com.internship.QuizGame.dataloader;

import com.internship.QuizGame.model.Admin;
import com.internship.QuizGame.model.Player;
import com.internship.QuizGame.repository.AdminRepository;
import com.internship.QuizGame.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
//    private final BCryptPasswordEncoder encoder;
    private final PlayerRepository playerRepository;
    private final AdminRepository adminRepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    Player player1 = Player.builder()
            .userName("player1")
//            .password(encoder.encode("player1"))
            .isActive(true)
            .roles("ROLE_PLAYER")
            .name("Andrew Kane")
            .age(23)
            .build();

    Player player2 = Player.builder()
            .userName("player2")
//            .password(encoder.encode("player2"))
            .isActive(true)
            .roles("ROLE_PLAYER")
            .name("Mathew Robinson")
            .age(27)
            .build();
    Player player3 = Player.builder()
            .userName("player3")
//            .password(encoder.encode("player3"))
            .isActive(true)
            .roles("ROLE_PLAYER")
            .name("Raphaela Tomson")
            .age(30)
            .build();

                playerRepository.save(player1);
                playerRepository.save(player2);
                playerRepository.save(player3);

        Admin admin = Admin.builder()
                .userName("admin")
//                .password(encoder.encode("admin"))
                .isActive(true)
                .roles("ROLE_ADMIN")
                .build();
        adminRepository.save(admin);

    }

}
