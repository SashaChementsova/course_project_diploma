package com.service.serviceImpl;

import com.model.LanguageTestHasQuestionEntity;
import com.repository.LanguageTestHasQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguageTestHasQuestionServiceImpl {
    private final LanguageTestHasQuestionRepository languageTestHasQuestionRepository;
    @Autowired
    public LanguageTestHasQuestionServiceImpl(LanguageTestHasQuestionRepository languageTestHasQuestionRepository){
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
