package com.ankush.quizapp.service;

import com.ankush.quizapp.dao.QuestionDao;
import com.ankush.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        System.out.println("getAllQuestions");
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch(Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(questionDao.findAll(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        System.out.println("getQuestionByCategory");
        try {
        return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }catch(Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
    }

    public Question getQuestionById(int id) {
        System.out.println("getQuestionById");
        return questionDao.findById(id).orElseThrow(() -> new RuntimeException("Question not found with ID: " + id));
    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("Question added successfully", HttpStatus.CREATED);
    }
}
