package com.ust.QuestionService.dto;

import com.ust.QuestionService.model.Answers;
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

    @NotBlank(message = "Set ID is mandatory")
    private String setid;

    @NotEmpty(message = "Answers list cannot be empty")
    private List<AnswersDto> answers;
}
