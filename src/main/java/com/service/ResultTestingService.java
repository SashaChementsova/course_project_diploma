package com.service;

import com.model.ResultTestingEntity;
import com.repository.ResultTestingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ResultTestingService {
    private final ResultTestingRepository resultTestingRepository;
    @Autowired
    public ResultTestingService(ResultTestingRepository resultRepository){
        this.resultTestingRepository = resultRepository;
    }

    public ResultTestingEntity addAndUpdateResultTesting(ResultTestingEntity resultTestingEntity){
        return resultTestingRepository.save(resultTestingEntity);
    }
    public List<ResultTestingEntity> getResultTestings(){
        return resultTestingRepository.findAll();
    }

    public ResultTestingEntity findResultTestingById(int id){

        return resultTestingRepository.findById(id).orElse(null);
    }
    public void deleteResultTesting(int id){
        resultTestingRepository.deleteById(id);
    }
}
