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

        if (setname == null || setname.isEmpty()) {
            throw new IllegalArgumentException("Set name cannot be null or empty");
        }
        if (qid == null || qid.isEmpty()) {
            throw new IllegalArgumentException("Question ID cannot be null or empty");
        }
    Question existingQuestion = findQuestionByQidAndSetname(qid, setname);
        if (existingQuestion == null) {
            throw new EntityNotFoundException("Question not found with qid: " + qid + " and setname: " + setname);
        }

        System.out.println("Updating question with qid: " + qid + " and setname: " + setname);

        if (question != null) {
            if (question.getQdetails() != null) {
                existingQuestion.setQdetails(question.getQdetails());
            }
            if (question.getCreatedby() != null) {
                existingQuestion.setCreatedby(question.getCreatedby());
            }
            if (question.getSetname() != null) {
                existingQuestion.setSetname(question.getSetname());
            }
            if (question.getAnswers() != null) {
                existingQuestion.setAnswers(question.getAnswers());
            }
        } else {
            throw new IllegalArgumentException("Question object cannot be null");
        }

        existingQuestion = saveQuestion(existingQuestion);

        return existingQuestion;
    }

    public void deleteAssessmentByQidAndSetname(String setname, String qid) {

        if (setname == null || setname.isEmpty()) {
            throw new IllegalArgumentException("Set name cannot be null or empty");
        }
        if (qid == null || qid.isEmpty()) {
            throw new IllegalArgumentException("Question ID cannot be null or empty");
        }

        System.out.println("Deleting question with qid: " + qid + " and setname: " + setname);

        Question question = questionRepo.findByQidAndSetname(qid, setname)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with qid: " + qid + " and setname: " + setname));

        questionRepo.delete(question);
    }

    private Question saveQuestion(Question question) {
        return questionRepo.save(question);
    }

    private Question findQuestionByQidAndSetname(String qid, String setname) {
        return questionRepo.findByQidAndSetname(qid, setname)
                .orElse(null);
    }
}
