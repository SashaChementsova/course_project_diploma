package com.service.serviceImpl;

import com.model.PositionName;
import com.repository.PositionNameRepository;
import com.service.PositionNameService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionNameServiceImpl implements PositionNameService {
    private final PositionNameRepository positionNameRepository;
    @Autowired
    public PositionNameServiceImpl(PositionNameRepository positionNameRepository){
        this.positionNameRepository = positionNameRepository;
    }
    @Override
    public PositionName addAndUpdatePositionName(PositionName positionName){
        return positionNameRepository.save(positionName);
    }
    @Override
    public List<PositionName> getPositionNames(){
        return positionNameRepository.findAll();
    }
    @Override
    public PositionName findPositionNameById(int id){

        return positionNameRepository.findById(id).orElse(null);
    }
    @Override
    public void deletePositionName(int id){
        positionNameRepository.deleteById(id);
    }

    @Override
    public void initializePositionName(){
        try {
            positionNameRepository.save(new PositionName("HR-менеджер"));
        }
        catch (Exception ex){
            System.out.println("Значения уже есть");
        }
    }
}
