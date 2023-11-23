package com.service;

import com.model.ResultEntity;
import com.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ResultService {
    private final ResultRepository resultRepository;
    @Autowired
    public ResultService(ResultRepository resultRepository){
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
