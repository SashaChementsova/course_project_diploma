package com.service;

import com.model.LanguageNameEntity;
import com.repository.LanguageNameRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LanguageNameService {
    private final LanguageNameRepository languageNameRepository;
    @Autowired
    public LanguageNameService(LanguageNameRepository languageNameRepository){
        this.languageNameRepository = languageNameRepository;
    }

    public LanguageNameEntity addAndUpdateLanguageName(LanguageNameEntity languageNameEntity){
        return languageNameRepository.save(languageNameEntity);
    }
    public List<LanguageNameEntity> getLanguageNames(){
        return languageNameRepository.findAll();
    }

    public LanguageNameEntity findLanguageNameById(int id){

        return languageNameRepository.findById(id).orElse(null);
    }
    public void deleteLanguageName(int id){
        languageNameRepository.deleteById(id);
    }
}
