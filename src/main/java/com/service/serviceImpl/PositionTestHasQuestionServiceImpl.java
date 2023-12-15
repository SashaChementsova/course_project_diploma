package com.service.serviceImpl;

import com.model.*;
import com.repository.PositionTestHasQuestionRepository;
import com.service.PositionTestHasQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionTestHasQuestionServiceImpl implements PositionTestHasQuestionService {
    private final PositionTestHasQuestionRepository positionTestHasQuestionRepository;
    @Autowired
    public PositionTestHasQuestionServiceImpl(PositionTestHasQuestionRepository positionTestHasQuestionRepository){
        this.positionTestHasQuestionRepository = positionTestHasQuestionRepository;
    }
    @Override
    public PositionTestHasQuestion addAndUpdatePositionTestHasQuestion(PositionTestHasQuestion positionTestHasQuestion){
        return positionTestHasQuestionRepository.save(positionTestHasQuestion);
    }
    @Override
    public List<PositionTestHasQuestion> getPositionTestHasQuestions(){
        return positionTestHasQuestionRepository.findAll();
    }
    @Override
    public PositionTestHasQuestion findPositionTestHasQuestionById(int id){

        return positionTestHasQuestionRepository.findById(id).orElse(null);
    }
    @Override
    public void deletePositionTestHasQuestion(int id){
        positionTestHasQuestionRepository.deleteById(id);
    }

    @Override
    public void createTesting(PositionTest positionTest, List<PositionTestQuestion> positionTestQuestions){
        if(positionTestQuestions!=null){
            if(!(positionTestQuestions.isEmpty())){
                for(PositionTestQuestion positionTestQuestion:positionTestQuestions){
                    PositionTestHasQuestion positionTestHasQuestion=new PositionTestHasQuestion();
                    positionTestHasQuestion.setPositionTest(positionTest);
                    positionTestHasQuestion.setPositionTestQuestion(positionTestQuestion);
                    positionTestHasQuestion.setStatus("Не начат");
                    addAndUpdatePositionTestHasQuestion(positionTestHasQuestion);
                }
            }
        }
    }

}
