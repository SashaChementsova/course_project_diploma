package com.service.serviceImpl;

import com.model.PositionName;
import com.model.PositionTest;
import com.model.PositionTestHasQuestion;
import com.model.PositionTestQuestion;
import com.repository.PositionTestHasQuestionRepository;
import com.repository.PositionTestQuestionRepository;
import com.service.PositionTestQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PositionTestQuestionServiceImpl implements PositionTestQuestionService {
    private final PositionTestQuestionRepository positionTestQuestionRepository;
    private final PositionTestHasQuestionRepository positionTestHasQuestionRepository;
    @Autowired
    public PositionTestQuestionServiceImpl(PositionTestQuestionRepository positionTestQuestionRepository,PositionTestHasQuestionRepository positionTestHasQuestionRepository){
        this.positionTestQuestionRepository = positionTestQuestionRepository;
        this.positionTestHasQuestionRepository=positionTestHasQuestionRepository;
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

    @Override
    public List<PositionTestQuestion> getPositionTestQuestionsByPositionName(PositionName positionName){
        List<PositionTestQuestion> positionTestQuestions=positionTestQuestionRepository.findAll();
        if(positionTestQuestions.isEmpty()) return null;
        List<PositionTestQuestion> resultPositionTestQuestions = new ArrayList<>();
        for(PositionTestQuestion positionTestQuestion:positionTestQuestions){
            if(positionTestQuestion.getPosition().getPositionName().getIdPositionName()==positionName.getIdPositionName()){
                resultPositionTestQuestions.add(positionTestQuestion);
            }
        }
        return resultPositionTestQuestions;
    }

    @Override
    public boolean checkDateOfPositionTestByQuestions(List<PositionTestQuestion> positionTestQuestions){
        for(PositionTestQuestion positionTestQuestion:positionTestQuestions){
            List<PositionTestHasQuestion> positionTestHasQuestions=positionTestQuestion.getPositionTestHasQuestionEntities();
            if(positionTestHasQuestions!=null){
                if(!(positionTestHasQuestions.isEmpty())){
                    for(PositionTestHasQuestion positionTestHasQuestion: positionTestHasQuestions){
                        PositionTest positionTest=positionTestHasQuestion.getPositionTest();
                        if(positionTest.getDate().compareTo(new java.util.Date())<=0){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void deleteQuestionsByPositionName(PositionName positionName){
        List<PositionTestQuestion> positionTestQuestions=getPositionTestQuestionsByPositionName(positionName);
        if(positionTestQuestions!=null){
            if(!(positionTestQuestions.isEmpty())) {
                for(PositionTestQuestion positionTestQuestion:positionTestQuestions){
                    List<PositionTestHasQuestion> positionTestHasQuestions=positionTestQuestion.getPositionTestHasQuestionEntities();
                    if(positionTestHasQuestions!=null){
                        if(!(positionTestHasQuestions.isEmpty())){
                            for(PositionTestHasQuestion positionTestHasQuestion:positionTestHasQuestions){
                                positionTestHasQuestion.setPositionTestQuestion(null);
                                positionTestHasQuestionRepository.save(positionTestHasQuestion);
                            }
                        }
                    }
                    deletePositionTestQuestion(positionTestQuestion.getIdPositionTestQuestion());
                }
            }
        }
    }
}
