package com.service;

import com.model.LanguageTestEntity;
import com.repository.LanguageTestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LanguageTestService {
    private final LanguageTestRepository languageTestRepository;
    @Autowired
    public LanguageTestService(LanguageTestRepository languageTestRepository){
        this.languageTestRepository = languageTestRepository;
    }

    public LanguageTestEntity addAndUpdateLanguageTest(LanguageTestEntity languageTestEntity){
        return languageTestRepository.save(languageTestEntity);
    }
    public List<LanguageTestEntity> getLanguageTests(){
        return languageTestRepository.findAll();
    }

    public LanguageTestEntity findLanguageTestById(int id){

        return languageTestRepository.findById(id).orElse(null);
    }
    public void deleteLanguageTest(int id){
        languageTestRepository.deleteById(id);
    }
}
