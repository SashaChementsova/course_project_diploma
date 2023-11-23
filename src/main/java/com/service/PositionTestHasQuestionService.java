package com.service;

import com.model.PositionTestHasQuestion;

import java.util.List;

public interface PositionTestHasQuestionService {
    public PositionTestHasQuestion addAndUpdatePositionTestHasQuestion(PositionTestHasQuestion positionTestHasQuestion);
    public List<PositionTestHasQuestion> getPositionTestHasQuestions();
    public PositionTestHasQuestion findPositionTestHasQuestionById(int id);
    public void deletePositionTestHasQuestion(int id);
}
