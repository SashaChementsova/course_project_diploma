package com.service.serviceImpl;

import com.model.LanguageTest;
import com.model.LanguageTestHasQuestion;
import com.model.LanguageTestQuestion;
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

    @Override
    public void createTesting(LanguageTest languageTest, List<LanguageTestQuestion> languageTestQuestions){
        if(languageTestQuestions!=null){
            if(!(languageTestQuestions.isEmpty())){
                for(LanguageTestQuestion languageTestQuestion:languageTestQuestions){
                    LanguageTestHasQuestion languageTestHasQuestion=new LanguageTestHasQuestion();
                    languageTestHasQuestion.setLanguageTest(languageTest);
                    languageTestHasQuestion.setLanguageTestQuestion(languageTestQuestion);
                    languageTestHasQuestion.setStatus("Не начат");
                    addAndUpdateLanguageTestHasQuestion(languageTestHasQuestion);
                }
            }
        }
    }
}
