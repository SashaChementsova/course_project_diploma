package com.service;

import com.model.PositionTestQuestionEntity;
import com.repository.PositionTestQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionTestQuestionService {
    private final PositionTestQuestionRepository positionTestQuestionRepository;
    @Autowired
    public PositionTestQuestionService(PositionTestQuestionRepository positionTestQuestionRepository){
        this.positionTestQuestionRepository = positionTestQuestionRepository;
    }

    public PositionTestQuestionEntity addAndUpdatePositionTestQuestion(PositionTestQuestionEntity positionTestQuestionEntity){
        return positionTestQuestionRepository.save(positionTestQuestionEntity);
    }
    public List<PositionTestQuestionEntity> getPositionTestQuestions(){
        return positionTestQuestionRepository.findAll();
    }

    public PositionTestQuestionEntity findPositionTestQuestionById(int id){

        return positionTestQuestionRepository.findById(id).orElse(null);
    }
    public void deletePositionTestQuestion(int id){
        positionTestQuestionRepository.deleteById(id);
    }
}
