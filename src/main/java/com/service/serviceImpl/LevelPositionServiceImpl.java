package com.service.serviceImpl;

import com.model.LevelPositionEntity;
import com.repository.LevelPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LevelPositionServiceImpl {
    private final LevelPositionRepository levelPositionRepository;
    @Autowired
    public LevelPositionServiceImpl(LevelPositionRepository levelPositionRepository){
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
