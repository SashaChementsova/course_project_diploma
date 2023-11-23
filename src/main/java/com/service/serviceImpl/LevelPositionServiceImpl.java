package com.service.serviceImpl;

import com.model.LevelPosition;
import com.repository.LevelPositionRepository;
import com.service.LevelPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LevelPositionServiceImpl implements LevelPositionService {
    private final LevelPositionRepository levelPositionRepository;
    @Autowired
    public LevelPositionServiceImpl(LevelPositionRepository levelPositionRepository){
        this.levelPositionRepository = levelPositionRepository;
    }
    @Override
    public LevelPosition addAndUpdateLevelPosition(LevelPosition levelPosition){
        return levelPositionRepository.save(levelPosition);
    }
    @Override
    public List<LevelPosition> getLevelPositions(){
        return levelPositionRepository.findAll();
    }
    @Override
    public LevelPosition findLevelPositionById(int id){

        return levelPositionRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteLevelPosition(int id){
        levelPositionRepository.deleteById(id);
    }
}
