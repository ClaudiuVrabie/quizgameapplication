package com.internship.QuizGame.repository;

import com.internship.QuizGame.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    public List<Question> findAll(){
//        String query = "SELECT * FROM questions";
//        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Question.class));
//    }
}
