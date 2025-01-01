package com.ankush.quizapp.service;

import com.ankush.quizapp.dao.QuestionDao;
import com.ankush.quizapp.dao.QuizDao;
import com.ankush.quizapp.model.Question;
import com.ankush.quizapp.model.QuestionWrapper;
import com.ankush.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions = questionDao.findRandomQuestionByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Quiz Created", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
          Optional<Quiz> quiz = quizDao.findById(id);
          List<Question> questions = quiz.get().getQuestions();

          List<QuestionWrapper> questionWrappers = new ArrayList<>();
          for (Question q : questions) {
              QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(), q.getOption4());
              questionWrappers.add(qw);
          }

          return new ResponseEntity<>(questionWrappers, HttpStatus.OK);
    }
}
