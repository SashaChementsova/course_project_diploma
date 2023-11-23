package com.service;

import com.model.LevelPositionEntity;
import com.repository.LevelPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LevelPositionService {
    private final LevelPositionRepository levelPositionRepository;
    @Autowired
    public LevelPositionService(LevelPositionRepository levelPositionRepository){
        this.levelPositionRepository = levelPositionRepository;
    }

    public LevelPositionEntity addAndUpdateLevelPosition(LevelPositionEntity levelPositionEntity){
        return levelPositionRepository.save(levelPositionEntity);
    }
    public List<LevelPositionEntity> getLevelPositions(){
        return levelPositionRepository.findAll();
    }

    public LevelPositionEntity findLevelPositionById(int id){

        return levelPositionRepository.findById(id).orElse(null);
    }
    public void deleteLevelPosition(int id){
        levelPositionRepository.deleteById(id);
    }
}
