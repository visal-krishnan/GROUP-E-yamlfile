package com.ust.QuestionService.controller;

import com.ust.QuestionService.dto.AssessmentDto;
import com.ust.QuestionService.model.Assessment;
import com.ust.QuestionService.model.Question;
import com.ust.QuestionService.service.AssessmentService;
import com.ust.QuestionService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ust.QuestionService.dto.EntityToDto.convertToEntity;

@RestController
@RequestMapping("/assessments")
public class AssessmentController {



    @Autowired
    private AssessmentService assessmentService;

    @Autowired
    private QuestionService questionService;


    @PostMapping
    public Assessment createAssessment(@RequestBody AssessmentDto assessment) {

       return assessmentService.createAssessment(assessment);

    }
    @GetMapping
    public List<Assessment> getAssessments() {

        return assessmentService.getAllAssessments();

    }

    @GetMapping("/{setid}")
    public List<Question> getQuestions(@PathVariable String setid) {
        return questionService.getAllQuestions(setid);
    }

    @PutMapping("/{setid}/{qid}")
    public Question updateAssessmentbyqid(@PathVariable String setid,@PathVariable String qid, @RequestBody Question question) {

       return assessmentService.updateAssessmentbyqid(setid,qid, question);
    }

    @DeleteMapping("/{setid}/{qid}")
    public void deleteAssessment(@PathVariable String setid, @PathVariable String qid) {
        assessmentService.deleteAssessmentByQidAndSetId(setid, qid);
    }



}
