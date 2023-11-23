package com.service;

import com.model.LanguageTestQuestion;

import java.util.List;

public interface LanguageTestQuestionService {
    public LanguageTestQuestion addAndUpdateLanguageTestQuestion(LanguageTestQuestion languageTestQuestion);
    public List<LanguageTestQuestion> getLanguageTestQuestions();
    public LanguageTestQuestion findLanguageTestQuestionById(int id);
    public void deleteLanguageTestQuestion(int id);
}
