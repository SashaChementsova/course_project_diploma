package com.service.serviceImpl;

import com.model.VacancyEntity;
import com.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VacancyServiceImpl {
    private final VacancyRepository vacancyRepository;
    @Autowired
    public VacancyServiceImpl(VacancyRepository vacancyRepository){
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
