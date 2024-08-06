package com.ust.QuestionService.repo;

import com.ust.QuestionService.dto.QuestionDto;
import com.ust.QuestionService.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepo extends JpaRepository<QuestionDto,String> {

    List<Question> findBySetname(String setname);

    Optional<Question> findByQidAndSetname(String qid, String setname);
    //void deleteByQidAndSetname(String qid, String setname);
}
