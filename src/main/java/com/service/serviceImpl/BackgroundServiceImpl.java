package com.service.serviceImpl;


import com.model.BackgroundEntity;
import com.repository.BackgroundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BackgroundServiceImpl {
    private final BackgroundRepository backgroundRepository;
    @Autowired
    public BackgroundServiceImpl(BackgroundRepository backgroundRepository){
        this.backgroundRepository = backgroundRepository;
    }

    public BackgroundEntity addAndUpdateBackground(BackgroundEntity backgroundEntity){
        return backgroundRepository.save(backgroundEntity);
    }
    public List<BackgroundEntity> getBackgrounds(){
        return backgroundRepository.findAll();
    }

    public BackgroundEntity findBackgroundById(int id){

        return backgroundRepository.findById(id).orElse(null);
    }
    public void deleteBackground(int id){
        backgroundRepository.deleteById(id);
    }
}
