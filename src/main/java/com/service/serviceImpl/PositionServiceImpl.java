package com.service.serviceImpl;

import com.model.PositionEntity;
import com.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionServiceImpl {
    private final PositionRepository positionRepository;
    @Autowired
    public PositionServiceImpl(PositionRepository positionRepository){
        this.positionRepository = positionRepository;
    }

    public PositionEntity addAndUpdatePosition(PositionEntity positionEntity){
        return positionRepository.save(positionEntity);
    }
    public List<PositionEntity> getPositions(){
        return positionRepository.findAll();
    }

    public PositionEntity findPositionById(int id){

        return positionRepository.findById(id).orElse(null);
    }
    public void deletePosition(int id){
        positionRepository.deleteById(id);
    }
}