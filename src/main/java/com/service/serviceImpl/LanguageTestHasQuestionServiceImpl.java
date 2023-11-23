package com.service.serviceImpl;

import com.model.LanguageTestHasQuestion;
import com.repository.LanguageTestHasQuestionRepository;
import com.service.LanguageTestHasQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguageTestHasQuestionServiceImpl implements LanguageTestHasQuestionService {
    private final LanguageTestHasQuestionRepository languageTestHasQuestionRepository;
    @Autowired
    public LanguageTestHasQuestionServiceImpl(LanguageTestHasQuestionRepository languageTestHasQuestionRepository){
        this.languageTestHasQuestionRepository = languageTestHasQuestionRepository;
    }
    @Override
    public LanguageTestHasQuestion addAndUpdateLanguageTestHasQuestion(LanguageTestHasQuestion languageTestHasQuestion){
        return languageTestHasQuestionRepository.save(languageTestHasQuestion);
    }
    @Override
    public List<LanguageTestHasQuestion> getLanguageTestHasQuestions(){
        return languageTestHasQuestionRepository.findAll();
    }
    @Override
    public LanguageTestHasQuestion findLanguageTestHasQuestionById(int id){

        return languageTestHasQuestionRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteLanguageTestHasQuestion(int id){
        languageTestHasQuestionRepository.deleteById(id);
    }
}
