package com.ust.QuestionService.dto;

import com.ust.QuestionService.model.Question;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentDto {
    @NotBlank(message = "Assessment ID is mandatory")
    private String setid;

    @NotBlank(message = "Set name is mandatory")
    private String setname;

    @NotBlank(message = "Created by is mandatory")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Status must only contain alphabetic characters")
    private String createdby;

    @NotBlank(message = "Domain is mandatory")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Domain must only contain alphabetic characters")
    private String domain;

    @NotBlank(message = "Status is mandatory")
    @Pattern(regexp = "COMPLETED|IN_PROGRESS", message = "Status must be either COMPLETED or IN_PROGRESS")
    private String status;

    @NotBlank(message = "Category name is mandatory")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Status must only contain alphabetic characters")
    private String updatedby;

    private Date createdtimestamp;
    private Date updatedtimestamp;

    private List<QuestionDto> questions;
}