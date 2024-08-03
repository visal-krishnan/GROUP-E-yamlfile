package com.ust.QuestionService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assessment {
    @Id
    private String aid;
    private String setname;
    private String createdby;
    private String domain;
    private String status;
    private String cname;

    List<Question> questions ;

}
