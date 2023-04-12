package com.internship.QuizGame.service;

import com.internship.QuizGame.model.Question;
import com.internship.QuizGame.repository.QuestionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class QuestionService {
   private final QuestionRepository questionRepository;

    public Question findById(Integer questionId) {
        return questionRepository.findById(questionId)
                .orElseThrow(() -> new EntityNotFoundException("Question not found"));
    }
   public List<Question> findAll(){
    return questionRepository.findAll();
}
    public void save(Question question) {
        questionRepository.save(question);
    }

}
