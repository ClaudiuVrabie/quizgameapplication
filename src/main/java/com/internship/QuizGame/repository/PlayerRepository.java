package com.internship.QuizGame.repository;

import com.internship.QuizGame.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    Optional<Player> findByUserName(String userName);


//    public List<Player> findAll(){
//        String query = "SELECT * FROM players";
//        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Player.class));
//    }
}
