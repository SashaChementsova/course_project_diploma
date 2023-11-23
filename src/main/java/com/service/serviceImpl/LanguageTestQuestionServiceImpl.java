package com.service.serviceImpl;

import com.model.LanguageTestQuestionEntity;
import com.repository.LanguageTestQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguageTestQuestionServiceImpl {
    private final LanguageTestQuestionRepository languageTestQuestionRepository;
    @Autowired
    public LanguageTestQuestionServiceImpl(LanguageTestQuestionRepository languageTestQuestionRepository){
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
