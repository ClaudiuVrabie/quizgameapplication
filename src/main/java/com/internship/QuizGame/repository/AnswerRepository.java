package com.internship.QuizGame.repository;

import com.internship.QuizGame.model.Answer;
import com.internship.QuizGame.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPathFactoryBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    public List<Answer> findAll(){
//        String query = "SELECT * FROM answers";
//        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Answer.class));}

}
