package com.service.serviceImpl;

import com.model.LanguageTestQuestion;
import com.repository.LanguageTestQuestionRepository;
import com.service.LanguageTestQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguageTestQuestionServiceImpl implements LanguageTestQuestionService {
    private final LanguageTestQuestionRepository languageTestQuestionRepository;
    @Autowired
    public LanguageTestQuestionServiceImpl(LanguageTestQuestionRepository languageTestQuestionRepository){
        this.languageTestQuestionRepository = languageTestQuestionRepository;
    }
    @Override
    public LanguageTestQuestion addAndUpdateLanguageTestQuestion(LanguageTestQuestion languageTestQuestion){
        return languageTestQuestionRepository.save(languageTestQuestion);
    }
    @Override
    public List<LanguageTestQuestion> getLanguageTestQuestions(){
        return languageTestQuestionRepository.findAll();
    }
    @Override
    public LanguageTestQuestion findLanguageTestQuestionById(int id){

        return languageTestQuestionRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteLanguageTestQuestion(int id){
        languageTestQuestionRepository.deleteById(id);
    }
}
