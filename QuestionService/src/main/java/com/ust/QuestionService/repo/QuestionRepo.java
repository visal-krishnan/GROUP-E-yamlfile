package com.ust.QuestionService.repo;

import com.ust.QuestionService.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question,String> {
}
