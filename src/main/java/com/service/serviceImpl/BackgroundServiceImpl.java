package com.service.serviceImpl;


import com.model.Background;
import com.repository.BackgroundRepository;
import com.service.BackgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BackgroundServiceImpl implements BackgroundService {
    private final BackgroundRepository backgroundRepository;
    @Autowired
    public BackgroundServiceImpl(BackgroundRepository backgroundRepository){
        this.backgroundRepository = backgroundRepository;
    }
    @Override
    public Background addAndUpdateBackground(Background background){
        return backgroundRepository.save(background);
    }
    @Override
    public List<Background> getBackgrounds(){
        return backgroundRepository.findAll();
    }
    @Override
    public Background findBackgroundById(int id){

        return backgroundRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteBackground(int id){
        backgroundRepository.deleteById(id);
    }
}
