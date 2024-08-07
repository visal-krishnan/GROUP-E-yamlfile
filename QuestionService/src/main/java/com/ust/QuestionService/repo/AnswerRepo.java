package com.ust.QuestionService.repo;

import com.ust.QuestionService.dto.AnswersDto;
import com.ust.QuestionService.model.Answers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepo extends JpaRepository<Answers,String> {
}
