package com.service;

import com.model.LanguageTestQuestionEntity;
import com.repository.LanguageTestQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LanguageTestQuestionService {
    private final LanguageTestQuestionRepository languageTestQuestionRepository;
    @Autowired
    public LanguageTestQuestionService(LanguageTestQuestionRepository languageTestQuestionRepository){
        this.languageTestQuestionRepository = languageTestQuestionRepository;
    }

    public LanguageTestQuestionEntity addAndUpdateLanguageTestQuestion(LanguageTestQuestionEntity languageTestQuestionEntity){
        return languageTestQuestionRepository.save(languageTestQuestionEntity);
    }
    public List<LanguageTestQuestionEntity> getLanguageTestQuestions(){
        return languageTestQuestionRepository.findAll();
    }

    public LanguageTestQuestionEntity findLanguageTestQuestionById(int id){

        return languageTestQuestionRepository.findById(id).orElse(null);
    }
    public void deleteLanguageTestQuestion(int id){
        languageTestQuestionRepository.deleteById(id);
    }
}
