package com.example.QuestionService.service;

import com.example.QuestionService.model.Question;
import com.example.QuestionService.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {


    @Autowired
    private final QuestionRepo questionRepo;

    public QuestionService(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    public List<Question> getAllQuestions(String setname) {
        return questionRepo.findBySetname(setname);
    }


}
