package com.internship.QuizGame.service;

import com.internship.QuizGame.model.Answer;
import com.internship.QuizGame.model.Question;
import com.internship.QuizGame.repository.AnswerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

//    public AnswerService(AnswerRepository answerRepository){
//        this.answerRepository = answerRepository;
//    }
    public List<Answer> findAll(){
        return answerRepository.findAll();
    }
    public Answer findById(Integer answerId) {
        return answerRepository.findById(answerId)
                .orElseThrow(() -> new EntityNotFoundException("Answer not found"));
    }
    public void save(Answer answer) {
        answerRepository.save(answer);
    }
}
