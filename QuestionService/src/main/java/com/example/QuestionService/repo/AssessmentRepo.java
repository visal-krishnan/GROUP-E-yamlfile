package com.example.QuestionService.repo;

import com.example.QuestionService.model.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRepo extends JpaRepository<Assessment,Long> {
}
