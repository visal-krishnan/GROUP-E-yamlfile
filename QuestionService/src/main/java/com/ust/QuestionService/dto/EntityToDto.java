package com.ust.QuestionService.dto;

import com.ust.QuestionService.model.Answers;
import com.ust.QuestionService.model.Assessment;
import com.ust.QuestionService.model.Question;

import java.util.List;
import java.util.stream.Collectors;

public class EntityToDto {


    public static AnswersDto convertToDto(Answers answers) {
        if (answers == null) {
            return null;
        }
        return AnswersDto.builder()
                .answerid(answers.getAnswerid())
                .answer(answers.getAnswer())
                .suggestion(answers.getSuggestion())
                //.qid(answers.getQid())
                .build();
    }


    public static Answers convertToEntity(AnswersDto AnswersDto) {
        if (AnswersDto == null) {
            return null;
        }
        return Answers.builder()
                .answerid(AnswersDto.getAnswerid())
                .answer(AnswersDto.getAnswer())
                .suggestion(AnswersDto.getSuggestion())
               // .qid(AnswersDto.getQid())
                .build();
    }


    public static QuestionDto convertToDto(Question question) {
        if (question == null) {
            return null;
        }

        return QuestionDto.builder()
                .qid(question.getQid())
                .qdetails(question.getQdetails())
                .setid(question.getSetid())
                .build();
    }


    public static Question convertToEntity(QuestionDto questionDto) {
        if (questionDto == null) {
            return null;
        }
//        List<Answers> answersList = questionDto.getAnswers().stream()
//                .map(EntityToDto::convertToEntity)
//                .collect(Collectors.toList());

        return Question.builder()
                .qid(questionDto.getQid())
                .qdetails(questionDto.getQdetails())
                .setid(questionDto.getSetid())
                .build();
    }


    public static AssessmentDto convertToDto(Assessment assessment) {
        if (assessment == null) {
            return null;
        }




        return AssessmentDto.builder()
                .setid(assessment.getSetid())
                .setname(assessment.getSetname())
                .createdby(assessment.getCreatedby())
                .domain(assessment.getDomain())
                .status(assessment.getStatus())
                .updatedby(assessment.getUpdatedby())
                .createdtimestamp(assessment.getCreatedtimestamp())
                .updatedtimestamp(assessment.getUpdatedtimestamp())
                .build();
    }


    public static Assessment convertToEntity(AssessmentDto assessmentDTO) {
        if (assessmentDTO == null) {
            return null;
        }

//        List<Question> questionsList = assessmentDTO.getQuestions().stream()
//                .map(EntityToDto::convertToEntity)
//                .collect(Collectors.toList());

        return Assessment.builder()
                .setid(assessmentDTO.getSetid())
                .setname(assessmentDTO.getSetname())
                .createdby(assessmentDTO.getCreatedby())
                .domain(assessmentDTO.getDomain())
                .status(assessmentDTO.getStatus())
                .updatedby(assessmentDTO.getUpdatedby())
                .createdtimestamp(assessmentDTO.getCreatedtimestamp())
                .updatedtimestamp(assessmentDTO.getUpdatedtimestamp())
                .build();
    }
}