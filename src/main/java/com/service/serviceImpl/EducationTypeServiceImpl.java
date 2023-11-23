package com.service.serviceImpl;

import com.model.EducationTypeEntity;
import com.repository.EducationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationTypeServiceImpl {
    private final EducationTypeRepository educationTypeRepository;
    @Autowired
    public EducationTypeServiceImpl(EducationTypeRepository educationTypeRepository){
        this.educationTypeRepository = educationTypeRepository;
    }

    public EducationTypeEntity addAndUpdateEducationType(EducationTypeEntity educationTypeEntity){
        return educationTypeRepository.save(educationTypeEntity);
    }
    public List<EducationTypeEntity> getEducationTypes(){
        return educationTypeRepository.findAll();
    }

    public EducationTypeEntity findEducationTypeById(int id){

        return educationTypeRepository.findById(id).orElse(null);
    }
    public void deleteEducationType(int id){
        educationTypeRepository.deleteById(id);
    }
}
