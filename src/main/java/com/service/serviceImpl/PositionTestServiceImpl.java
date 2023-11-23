package com.service.serviceImpl;

import com.model.PositionTestEntity;
import com.repository.PositionTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionTestServiceImpl {
    private final PositionTestRepository positionTestRepository;
    @Autowired
    public PositionTestServiceImpl(PositionTestRepository positionTestRepository){
        this.positionTestRepository = positionTestRepository;
    }

    public PositionTestEntity addAndUpdatePositionTest(PositionTestEntity positionTestEntity){
        return positionTestRepository.save(positionTestEntity);
    }
    public List<PositionTestEntity> getPositionTests(){
        return positionTestRepository.findAll();
    }

    public PositionTestEntity findPositionTestById(int id){

        return positionTestRepository.findById(id).orElse(null);
    }
    public void deletePositionTest(int id){
        positionTestRepository.deleteById(id);
    }
}
