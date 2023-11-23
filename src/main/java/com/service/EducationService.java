package com.service;

import com.model.EducationEntity;
import com.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EducationService {
    private final EducationRepository educationRepository;
    @Autowired
    public EducationService(EducationRepository educationRepository){
        this.educationRepository = educationRepository;
    }

    public EducationEntity addAndUpdateEducation(EducationEntity educationEntity){
        return educationRepository.save(educationEntity);
    }
    public List<EducationEntity> getEducations(){
        return educationRepository.findAll();
    }

    public EducationEntity findEducationById(int id){

        return educationRepository.findById(id).orElse(null);
    }
    public void deleteEducation(int id){
        educationRepository.deleteById(id);
    }
}
