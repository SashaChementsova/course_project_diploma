package com.service;

import com.model.PositionTestQuestion;

import java.util.List;

public interface PositionTestQuestionService {
    public PositionTestQuestion addAndUpdatePositionTestQuestion(PositionTestQuestion positionTestQuestion);
    public List<PositionTestQuestion> getPositionTestQuestions();

    public PositionTestQuestion findPositionTestQuestionById(int id);
    public void deletePositionTestQuestion(int id);
}
