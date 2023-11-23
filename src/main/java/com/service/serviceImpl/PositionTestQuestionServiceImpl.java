package com.service.serviceImpl;

import com.model.PositionTestQuestion;
import com.repository.PositionTestQuestionRepository;
import com.service.PositionTestQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionTestQuestionServiceImpl implements PositionTestQuestionService {
    private final PositionTestQuestionRepository positionTestQuestionRepository;
    @Autowired
    public PositionTestQuestionServiceImpl(PositionTestQuestionRepository positionTestQuestionRepository){
        this.positionTestQuestionRepository = positionTestQuestionRepository;
    }
    @Override
    public PositionTestQuestion addAndUpdatePositionTestQuestion(PositionTestQuestion positionTestQuestion){
        return positionTestQuestionRepository.save(positionTestQuestion);
    }
    @Override
    public List<PositionTestQuestion> getPositionTestQuestions(){
        return positionTestQuestionRepository.findAll();
    }
    @Override
    public PositionTestQuestion findPositionTestQuestionById(int id){

        return positionTestQuestionRepository.findById(id).orElse(null);
    }
    @Override
    public void deletePositionTestQuestion(int id){
        positionTestQuestionRepository.deleteById(id);
    }
}
