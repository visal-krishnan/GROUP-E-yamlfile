package com.ust.QuestionService.repo;

import com.ust.QuestionService.dto.QuestionDto;
import com.ust.QuestionService.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepo extends JpaRepository<Question,String> {

    List<Question> findBySetid(String setid);

    Optional<Question> findByQidAndSetid(String qid, String setid);
    //void deleteByQidAndSetname(String qid, String setname);
}
