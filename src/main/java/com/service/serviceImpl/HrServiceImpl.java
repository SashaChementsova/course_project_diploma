package com.service.serviceImpl;

import com.model.HrEntity;
import com.repository.HrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HrServiceImpl {
    private final HrRepository hrRepository;
    @Autowired
    public HrServiceImpl(HrRepository hrRepository){
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
