package com.service.serviceImpl;

import com.model.ResultTestingEntity;
import com.repository.ResultTestingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResultTestingServiceImpl {
    private final ResultTestingRepository resultTestingRepository;
    @Autowired
    public ResultTestingServiceImpl(ResultTestingRepository resultRepository){
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
