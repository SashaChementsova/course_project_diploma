package com.service.serviceImpl;

import com.model.Position;
import com.repository.PositionRepository;
import com.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;
    @Autowired
    public PositionServiceImpl(PositionRepository positionRepository){
        this.positionRepository = positionRepository;
    }
    @Override
    public Position addAndUpdatePosition(Position position){
        return positionRepository.save(position);
    }
    @Override
    public List<Position> getPositions(){
        return positionRepository.findAll();
    }
    @Override
    public Position findPositionById(int id){

        return positionRepository.findById(id).orElse(null);
    }
    @Override
    public void deletePosition(int id){
        positionRepository.deleteById(id);
    }
}
