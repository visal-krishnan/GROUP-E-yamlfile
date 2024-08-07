package com.ust.QuestionService.service;

import com.ust.QuestionService.dto.AssessmentDto;
import com.ust.QuestionService.model.Assessment;
import com.ust.QuestionService.model.Question;
import com.ust.QuestionService.repo.AssessmentRepo;
import com.ust.QuestionService.repo.QuestionRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


import static com.ust.QuestionService.dto.EntityToDto.convertToEntity;

@Service
public class AssessmentService {

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private AssessmentRepo assessmentRepo;

    private Assessment assessment;



    public Assessment createAssessment(AssessmentDto assessment) {
        convertToEntity(assessment);
        Assessment assessment1 = convertToEntity(assessment);
        return assessmentRepo.save(assessment1);
    }

    public List<Assessment> getAllAssessments() {
        return assessmentRepo.findAll();
    }


    public Question updateAssessmentbyqid(String setId, String qid, Question question) {

        if (setId == null || setId.isEmpty()) {
            throw new IllegalArgumentException("Set name cannot be null or empty");
        }
        if (qid == null || qid.isEmpty()) {
            throw new IllegalArgumentException("Question ID cannot be null or empty");
        }
    Question existingQuestion = findQuestionByQidAndSetId(qid, setId);
        if (existingQuestion == null) {
            throw new EntityNotFoundException("Question not found with qid: " + qid + " and setId: " + setId);
        }

        System.out.println("Updating question with qid: " + qid + " and setId: " + setId);

        if (question != null) {
            if (question.getQdetails() != null) {
                existingQuestion.setQdetails(question.getQdetails());
            }
            if (question.getQid() != null) {
                existingQuestion.setQid(question.getQid());
            }
            if (question.getSetid() != null) {
                existingQuestion.setSetid(question.getSetid());
            }

        } else {
            throw new IllegalArgumentException("Question object cannot be null");
        }

        existingQuestion = saveQuestion(existingQuestion);

        return existingQuestion;
    }

    public void deleteAssessmentByQidAndSetId(String setid, String qid) {

        if (setid == null || setid.isEmpty()) {
            throw new IllegalArgumentException("Set id cannot be null or empty");
        }
        if (qid == null || qid.isEmpty()) {
            throw new IllegalArgumentException("Question ID cannot be null or empty");
        }

        System.out.println("Deleting question with qid: " + qid + " and setId: " + setid);

        Question question = questionRepo.findByQidAndSetid(qid, setid)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with qid: " + qid + " and setId: " + setid));

        questionRepo.delete(question);
    }

    private Question saveQuestion(Question question) {
        return questionRepo.save(question);
    }

    private Question findQuestionByQidAndSetId(String qid, String setid) {
        return questionRepo.findByQidAndSetid(qid, setid)
                .orElse(null);
    }
}
