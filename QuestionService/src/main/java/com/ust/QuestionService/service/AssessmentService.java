package com.ust.QuestionService.service;

import com.ust.QuestionService.dto.AssessmentDto;
import com.ust.QuestionService.dto.QuestionDto;
import com.ust.QuestionService.model.Assessment;
import com.ust.QuestionService.model.Question;
import com.ust.QuestionService.repo.AssessmentRepo;
import com.ust.QuestionService.repo.QuestionRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


import static com.ust.QuestionService.dto.EntityToDto.convertToEntity;

@Service
public class AssessmentService {

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private AssessmentRepo assessmentRepo;

    private Assessment assessment;



    public Assessment createAssessment(AssessmentDto assessment) {
      //  convertToEntity(assessment);
        Assessment assessment1 = convertToEntity(assessment);
        //assessment1.setQuestions(null);
        return assessmentRepo.save(assessment1);
    }

    public List<Assessment> getAllAssessments() {
        return assessmentRepo.findAll();
    }


    public Question updateAssessmentbyqid(String setid, String qid, QuestionDto question) {

        Optional<Assessment> setInfo= assessmentRepo.findById(setid);
        Optional<Question> updQuestion=questionRepo.findById(qid);
        Question question1 = convertToEntity(question);
        if(updQuestion.isPresent()&& setInfo.isPresent()){

            updQuestion.get().setSetid(question1.getSetid());
            updQuestion.get().setQid(question1.getQid());
            updQuestion.get().setQdetails(question1.getQdetails());
            updQuestion.get().setAnswers(question1.getAnswers());
            Question test = updQuestion.get();
            return questionRepo.save(test);

        }
        else{
            throw new RuntimeException("Question not found with questionid: " + qid + " and setname: " + setid);
        }
    }

    public void deleteAssessmentByQidAndSetId(String setid, String qid) {

        if (setid == null || setid.isEmpty()) {
            throw new IllegalArgumentException("Set name cannot be null or empty");
        }
        if (qid == null || qid.isEmpty()) {
            throw new IllegalArgumentException("Question ID cannot be null or empty");
        }


        Question question = (Question) questionRepo.findByQidAndSetid(qid, setid)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with questionid: " + qid + " and setname: " + setid));
        questionRepo.delete(question);
    }

//    private Question saveQuestion(Question question) {
//        return questionRepo.save(question);
//    }
//
//    private Question findQuestionByQidAndSetId(String qid, String setid) {
//        return questionRepo.findByQidAndSetid(qid, setid)
//                .orElse(null);
//    }
}
