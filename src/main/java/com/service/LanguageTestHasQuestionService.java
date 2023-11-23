package com.service;

import com.model.LanguageTestHasQuestion;

import java.util.List;

public interface LanguageTestHasQuestionService {
    public LanguageTestHasQuestion addAndUpdateLanguageTestHasQuestion(LanguageTestHasQuestion languageTestHasQuestion);
    public List<LanguageTestHasQuestion> getLanguageTestHasQuestions();

    public LanguageTestHasQuestion findLanguageTestHasQuestionById(int id);
    public void deleteLanguageTestHasQuestion(int id);
}
