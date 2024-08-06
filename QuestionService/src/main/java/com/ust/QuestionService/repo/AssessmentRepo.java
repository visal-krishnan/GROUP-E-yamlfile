package com.ust.QuestionService.repo;

import com.ust.QuestionService.dto.AssessmentDto;
import com.ust.QuestionService.model.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRepo extends JpaRepository<AssessmentDto,String> {
}
