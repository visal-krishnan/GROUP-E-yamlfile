package com.ust.QuestionService.service;

import com.ust.QuestionService.model.Question;
import com.ust.QuestionService.repo.QuestionRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;

    public List<Question> getAllQuestions(String setname) {
        return questionRepo.findBySetname(setname);
    }


}
