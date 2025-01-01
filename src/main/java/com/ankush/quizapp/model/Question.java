package com.ankush.quizapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="question")
public class Question {

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name = "question_seq", sequenceName = "question_id_seq", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_seq")
    @SequenceGenerator(name = "question_seq", sequenceName = "question_id_seq", allocationSize = 1, initialValue = 4)
    @JsonProperty("id")
    private int id;
    @JsonProperty("question_title")
    private String questionTitle;
    @JsonProperty("option_1")
    private String option1;
    @JsonProperty("option_2")
    private String option2;
    @JsonProperty("option_3")
    private String option3;
    @JsonProperty("option_4")
    private String option4;
    @JsonProperty("right_answer")
    private String rightAnswer;
    @JsonProperty("difficulty_level")
    private String difficultyLevel;
    @JsonProperty("category")
    private String category;

    public int getId() {
        return id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }
}
