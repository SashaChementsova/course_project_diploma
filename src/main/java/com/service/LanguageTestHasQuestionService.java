package com.service;

import com.model.LanguageTestHasQuestionEntity;
import com.repository.LanguageTestHasQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LanguageTestHasQuestionService {
    private final LanguageTestHasQuestionRepository languageTestHasQuestionRepository;
    @Autowired
    public LanguageTestHasQuestionService(LanguageTestHasQuestionRepository languageTestHasQuestionRepository){
        this.languageTestHasQuestionRepository = languageTestHasQuestionRepository;
    }

    public LanguageTestHasQuestionEntity addAndUpdateLanguageTestHasQuestion(LanguageTestHasQuestionEntity languageTestHasQuestionEntity){
        return languageTestHasQuestionRepository.save(languageTestHasQuestionEntity);
    }
    public List<LanguageTestHasQuestionEntity> getLanguageTestHasQuestions(){
        return languageTestHasQuestionRepository.findAll();
    }

    public LanguageTestHasQuestionEntity findLanguageTestHasQuestionById(int id){

        return languageTestHasQuestionRepository.findById(id).orElse(null);
    }
    public void deleteLanguageTestHasQuestion(int id){
        languageTestHasQuestionRepository.deleteById(id);
    }
}
