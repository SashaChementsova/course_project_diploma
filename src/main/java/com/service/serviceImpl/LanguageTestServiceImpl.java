package com.service.serviceImpl;

import com.model.LanguageTestEntity;
import com.repository.LanguageTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguageTestServiceImpl {
    private final LanguageTestRepository languageTestRepository;
    @Autowired
    public LanguageTestServiceImpl(LanguageTestRepository languageTestRepository){
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
