package com.ust.QuestionService.repo;

import com.ust.QuestionService.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question,String> {

    List<Question> findBySetname(String setname);
}
