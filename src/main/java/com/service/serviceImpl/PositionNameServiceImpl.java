package com.service.serviceImpl;

import com.model.PositionNameEntity;
import com.repository.PositionNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionNameServiceImpl {
    private final PositionNameRepository positionNameRepository;
    @Autowired
    public PositionNameServiceImpl(PositionNameRepository positionNameRepository){
        this.positionNameRepository = positionNameRepository;
    }

    public PositionNameEntity addAndUpdatePositionName(PositionNameEntity positionNameEntity){
        return positionNameRepository.save(positionNameEntity);
    }
    public List<PositionNameEntity> getPositionNames(){
        return positionNameRepository.findAll();
    }

    public PositionNameEntity findPositionNameById(int id){

        return positionNameRepository.findById(id).orElse(null);
    }
    public void deletePositionName(int id){
        positionNameRepository.deleteById(id);
    }
}
