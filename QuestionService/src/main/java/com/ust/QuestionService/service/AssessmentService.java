package com.ust.QuestionService.service;

import com.ust.QuestionService.model.Assessment;
import com.ust.QuestionService.model.Question;
import com.ust.QuestionService.repo.AssessmentRepo;
import com.ust.QuestionService.repo.QuestionRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentService {

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private AssessmentRepo assessmentRepo;

    private Assessment assessment;



    public Assessment createAssessment(Assessment assessment) {
        return assessmentRepo.save(assessment);
    }

    public List<Assessment> getAllAssessments() {
        return assessmentRepo.findAll();
    }


    public Question updateAssessmentbyqid(String setname, String qid, Question question) {
       
       

        Question existingQuestion = questionRepo.findByQidAndSetname(qid, setname).orElse(null);
        if (existingQuestion == null) {
            throw new EntityNotFoundException("Question not found with qid: " + qid + " and setname: " + setname);
        }

        existingQuestion.setQdetails(question.getQdetails());
        existingQuestion.setCreatedby(question.getCreatedby());
        existingQuestion.setSetname(question.getSetname());
        existingQuestion.setAnswers(question.getAnswers());

        existingQuestion = questionRepo.save(existingQuestion);

        return existingQuestion;
    }

    public void deleteAssessmentByQidAndSetname(String setname, String qid) {

        if (setname == null || setname.isEmpty()) {
            throw new IllegalArgumentException("Set name cannot be null or empty");
        }
        if (qid == null || qid.isEmpty()) {
            throw new IllegalArgumentException("Question ID cannot be null or empty");
        }


        Question question = questionRepo.findByQidAndSetname(qid, setname)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with qid: " + qid + " and setname: " + setname));
        questionRepo.delete(question);
    }


}
