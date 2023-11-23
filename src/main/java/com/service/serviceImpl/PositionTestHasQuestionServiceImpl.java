package com.service.serviceImpl;

import com.model.PositionTestHasQuestionEntity;
import com.repository.PositionTestHasQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionTestHasQuestionServiceImpl {
    private final PositionTestHasQuestionRepository positionTestHasQuestionRepository;
    @Autowired
    public PositionTestHasQuestionServiceImpl(PositionTestHasQuestionRepository positionTestHasQuestionRepository){
        this.positionTestHasQuestionRepository = positionTestHasQuestionRepository;
    }

    public PositionTestHasQuestionEntity addAndUpdatePositionTestHasQuestion(PositionTestHasQuestionEntity positionTestHasQuestionEntity){
        return positionTestHasQuestionRepository.save(positionTestHasQuestionEntity);
    }
    public List<PositionTestHasQuestionEntity> getPositionTestHasQuestions(){
        return positionTestHasQuestionRepository.findAll();
    }

    public PositionTestHasQuestionEntity findPositionTestHasQuestionById(int id){

        return positionTestHasQuestionRepository.findById(id).orElse(null);
    }
    public void deletePositionTestHasQuestion(int id){
        positionTestHasQuestionRepository.deleteById(id);
    }

}
