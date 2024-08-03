package com.ust.QuestionService.controller;

import com.ust.QuestionService.model.Assessment;
import com.ust.QuestionService.model.Question;
import com.ust.QuestionService.service.AnswersService;
import com.ust.QuestionService.service.AssessmentService;
import com.ust.QuestionService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assessments")
public class MainController {



    @Autowired
    private AssessmentService assessmentService;

    @Autowired
    private QuestionService questionService;


    @PostMapping
    public Assessment createAssessment(@RequestBody Assessment assessment) {

        return assessmentService.createAssessment(assessment);

    }
    @GetMapping
    public List<Assessment> getAssessments() {

        return assessmentService.getAllAssessments();

    }

    @GetMapping("/{setname}")
    public List<Question> getQuestions(@PathVariable String setname) {
        return questionService.getAllQuestions(setname);
    }
}
