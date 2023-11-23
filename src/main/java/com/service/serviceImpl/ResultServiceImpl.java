package com.service.serviceImpl;

import com.model.ResultEntity;
import com.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResultServiceImpl {
    private final ResultRepository resultRepository;
    @Autowired
    public ResultServiceImpl(ResultRepository resultRepository){
        this.resultRepository = resultRepository;
    }

    public ResultEntity addAndUpdateResult(ResultEntity resultEntity){
        return resultRepository.save(resultEntity);
    }
    public List<ResultEntity> getResults(){
        return resultRepository.findAll();
    }

    public ResultEntity findResultById(int id){

        return resultRepository.findById(id).orElse(null);
    }
    public void deleteResult(int id){
        resultRepository.deleteById(id);
    }
}
