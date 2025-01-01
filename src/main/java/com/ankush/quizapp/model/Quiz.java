package com.ankush.quizapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_seq")
    @SequenceGenerator(name = "question_seq", sequenceName = "question_id_seq", allocationSize = 1, initialValue = 4)
    @JsonProperty("id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("questions")
    @ManyToMany
    private List<Question> questions;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuestions(List<Question> question) {

        this.questions = question;
    }

}
