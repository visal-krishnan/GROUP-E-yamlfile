package com.example.QuestionService.Service;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CacheConfig;

import com.example.QuestionService.Dto.AssessmentDto;
import com.example.QuestionService.Dto.EntityToDto;
import com.example.QuestionService.Dto.QuestionDto;
import com.example.QuestionService.Model.Assessment;
import com.example.QuestionService.Model.Question;
import com.example.QuestionService.Model.Status;
import com.example.QuestionService.Repo.AssessmentRepo;
import com.example.QuestionService.Repo.QuestionRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = {"assessments", "questions"})
public class AssessmentService {

    private final QuestionRepo questionRepo;
    private final AssessmentRepo assessmentRepo;

    public AssessmentService(QuestionRepo questionRepo, AssessmentRepo assessmentRepo) {
        this.questionRepo = questionRepo;
        this.assessmentRepo = assessmentRepo;
    }

    @CachePut(value = "assessments")
    public Assessment createAssessment(AssessmentDto assessmentDto) {
        try {
            Assessment assessment = EntityToDto.convertToEntity(assessmentDto);
            assessment.setStatus(Status.IN_PROGRESS);
            return assessmentRepo.save(assessment);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create assessment", e);
        }
    }

    @Cacheable(value = "assessments")
    public List<Assessment> getAllAssessments() {
        try {
            return assessmentRepo.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get all assessments", e);
        }
    }

    @CachePut(value = "questions", key = "#qid")
    public Question updateAssessmentbyqid(Long setid, Long qid, QuestionDto questionDto) {
        Optional<Assessment> setInfo = assessmentRepo.findById(setid);
        Optional<Question> updQuestion = questionRepo.findById(qid);
        Question question = EntityToDto.convertToEntity(questionDto);

        if (updQuestion.isPresent() && setInfo.isPresent()) {
            updQuestion.get().setAnswers(question.getAnswers());
            return questionRepo.save(updQuestion.get());
        } else {
            throw new EntityNotFoundException("Assessment or Question not found");
        }
    }

    @CacheEvict(value = "questions", key = "#qid")
    public void deleteAssessmentByQidAndSetId(Long setid, Long qid) {
        if (setid == null) {
            throw new IllegalArgumentException("Set name cannot be null or empty");
        }
        if (qid == null) {
            throw new IllegalArgumentException("Question ID cannot be null or empty");
        }

        Question question = (Question) questionRepo.findByQidAndSetid(qid, setid)
                .orElseThrow(() -> new EntityNotFoundException("Question not found with questionid: " + qid + " and setname: " + setid));
        questionRepo.delete(question);
    }
    }

