package com.ust.QuestionService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.Date;
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
    private Date createdtimestamp;
    private Date updatedtimestamp;

    @OneToMany
    @JoinColumn(name="setid")
    @Cascade(value= CascadeType.ALL)
    @JsonIgnore
    private List<Question> questions;


}
