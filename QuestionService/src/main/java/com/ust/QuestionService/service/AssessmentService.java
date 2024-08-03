package com.ust.QuestionService.service;

import com.ust.QuestionService.model.Assessment;
import com.ust.QuestionService.model.Question;
import com.ust.QuestionService.repo.AssessmentRepo;
import com.ust.QuestionService.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentService {

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private AssessmentRepo assessmentRepo;



    public Assessment createAssessment(Assessment assessment) {
        return assessmentRepo.save(assessment);
    }

    public List<Assessment> getAllAssessments() {
        return assessmentRepo.findAll();
    }


}
