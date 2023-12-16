package com.service.serviceImpl;

import com.model.Trial;
import com.repository.TrialRepository;
import com.service.TrialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TrialServiceImpl implements TrialService {
    private final TrialRepository trialRepository;
    @Autowired
    public TrialServiceImpl(TrialRepository trialRepository){
        this.trialRepository = trialRepository;
    }
    @Override
    public Trial addAndUpdateTrial(Trial trial){
        return trialRepository.save(trial);
    }
    @Override
    public List<Trial> getTrials(){
        return trialRepository.findAll();
    }
    @Override
    public Trial findTrialById(int id){

        return trialRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteTrial(int id){
        trialRepository.deleteById(id);
    }

    @Override
    public List<Trial> getActiveTrial(){
        List<Trial> trials=getTrials();
        List<Trial> resultTrials=new ArrayList<>();
        if(trials!=null){
            if(!(trials.isEmpty())){
                for(Trial trial:trials){
                    if(trial.getStatus().equals("В процессе")){
                        resultTrials.add(trial);
                    }
                }
            }
        }
        return resultTrials;
    }
}
