package com.ust.QuestionService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    @NotBlank(message = "Question ID is mandatory")
    private String qid;

    @NotBlank(message = "Question details are mandatory")
    private String qdetails;

    @NotBlank(message = "Created by is mandatory")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Status must only contain alphabetic characters")
    private String createdby;

    @NotBlank(message = "Set name is mandatory")
    private String setname;

    @NotEmpty(message = "Answers list cannot be empty")
    private List<AnswersDto> answers;
}
