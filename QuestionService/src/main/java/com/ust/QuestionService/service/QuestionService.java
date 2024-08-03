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

    public void deleteAssessmentByQidAndSetname(String setname, String qid) {
        // Validate Inputs
        if (setname == null || setname.isEmpty()) {
            throw new IllegalArgumentException("Set name cannot be null or empty");
        }
        if (qid == null || qid.isEmpty()) {
            throw new IllegalArgumentException("Question ID cannot be null or empty");
        }

        // Check if the question exists
        Question question = questionRepo.findByQidAndSetname(qid, setname)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with qid: " + qid + " and setname: " + setname));

        // Delete the question
        questionRepo.deleteByQidAndSetname(qid, setname);
    }
}
