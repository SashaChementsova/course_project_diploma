package com.service.serviceImpl;

import com.model.LanguageEntity;
import com.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguageServiceImpl {
    private final LanguageRepository languageRepository;
    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }

    public LanguageEntity addAndUpdateLanguage(LanguageEntity languageEntity){
        return languageRepository.save(languageEntity);
    }

    public List<LanguageEntity> getLanguages(){
        return languageRepository.findAll();
    }

    public LanguageEntity findLanguageById(int id){
        return languageRepository.findById(id).orElse(null);
    }

    public void deleteLanguage(int id){
        languageRepository.deleteById(id);
    }
}
