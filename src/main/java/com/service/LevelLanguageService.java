package com.service;

import com.model.LevelLanguageEntity;
import com.repository.LevelLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LevelLanguageService {
    private final LevelLanguageRepository levelLanguageRepository;
    @Autowired
    public LevelLanguageService(LevelLanguageRepository levelLanguageRepository){
        this.levelLanguageRepository = levelLanguageRepository;
    }

    public LevelLanguageEntity addAndUpdateLevelLanguage(LevelLanguageEntity levelLanguageEntity){
        return levelLanguageRepository.save(levelLanguageEntity);
    }
    public List<LevelLanguageEntity> getLevelLanguages(){
        return levelLanguageRepository.findAll();
    }

    public LevelLanguageEntity findLevelLanguageById(int id){

        return levelLanguageRepository.findById(id).orElse(null);
    }
    public void deleteLevelLanguage(int id){
        levelLanguageRepository.deleteById(id);
    }
}
