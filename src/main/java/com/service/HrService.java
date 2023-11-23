package com.service;

import com.model.HrEntity;
import com.repository.HrRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HrService {
    private final HrRepository hrRepository;
    @Autowired
    public HrService(HrRepository hrRepository){
        this.hrRepository = hrRepository;
    }

    public HrEntity addAndUpdateHr(HrEntity hrEntity){
        return hrRepository.save(hrEntity);
    }
    public List<HrEntity> getHrs(){
        return hrRepository.findAll();
    }

    public HrEntity findHrById(int id){

        return hrRepository.findById(id).orElse(null);
    }
    public void deleteHr(int id){
        hrRepository.deleteById(id);
    }
}
