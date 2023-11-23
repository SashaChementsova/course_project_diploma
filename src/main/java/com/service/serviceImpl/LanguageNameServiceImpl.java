package com.service.serviceImpl;

import com.model.LanguageNameEntity;
import com.repository.LanguageNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguageNameServiceImpl {
    private final LanguageNameRepository languageNameRepository;
    @Autowired
    public LanguageNameServiceImpl(LanguageNameRepository languageNameRepository){
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