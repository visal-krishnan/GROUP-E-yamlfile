package com.ust.QuestionService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Assessment {
    @Id
    private String setid;
    private String setname;
    private String createdby;
    private String domain;
    private String status;
    private String updatedby;
    private String createdtimestamp;
    private String updatedtimestamp;


}
