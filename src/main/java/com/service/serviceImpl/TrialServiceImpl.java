package com.service.serviceImpl;

import com.model.TrialEntity;
import com.repository.TrialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrialServiceImpl {
    private final TrialRepository trialRepository;
    @Autowired
    public TrialServiceImpl(TrialRepository trialRepository){
        this.trialRepository = trialRepository;
    }

    public TrialEntity addAndUpdateTrial(TrialEntity trialEntity){
        return trialRepository.save(trialEntity);
    }
    public List<TrialEntity> getTrials(){
        return trialRepository.findAll();
    }

    public TrialEntity findTrialById(int id){

        return trialRepository.findById(id).orElse(null);
    }
    public void deleteTrial(int id){
        trialRepository.deleteById(id);
    }
}
