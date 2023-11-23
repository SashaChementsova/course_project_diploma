package com.service.serviceImpl;

import com.model.LevelLanguage;
import com.repository.LevelLanguageRepository;
import com.service.LevelLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LevelLanguageServiceImpl implements LevelLanguageService {
    private final LevelLanguageRepository levelLanguageRepository;
    @Autowired
    public LevelLanguageServiceImpl(LevelLanguageRepository levelLanguageRepository){
        this.levelLanguageRepository = levelLanguageRepository;
    }
    @Override
    public LevelLanguage addAndUpdateLevelLanguage(LevelLanguage levelLanguage){
        return levelLanguageRepository.save(levelLanguage);
    }
    @Override
    public List<LevelLanguage> getLevelLanguages(){
        return levelLanguageRepository.findAll();
    }
    @Override
    public LevelLanguage findLevelLanguageById(int id){

        return levelLanguageRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteLevelLanguage(int id){
        levelLanguageRepository.deleteById(id);
    }
}
