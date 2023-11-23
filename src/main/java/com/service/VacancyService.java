package com.service;

import com.model.VacancyEntity;
import com.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VacancyService {
    private final VacancyRepository vacancyRepository;
    @Autowired
    public VacancyService(VacancyRepository vacancyRepository){
        this.vacancyRepository = vacancyRepository;
    }

    public VacancyEntity addAndUpdateVacancy(VacancyEntity vacancyEntity){
        return vacancyRepository.save(vacancyEntity);
    }
    public List<VacancyEntity> getVacancies(){
        return vacancyRepository.findAll();
    }

    public VacancyEntity findVacancyById(int id){

        return vacancyRepository.findById(id).orElse(null);
    }
    public void deleteVacancy(int id){
        vacancyRepository.deleteById(id);
    }
}
