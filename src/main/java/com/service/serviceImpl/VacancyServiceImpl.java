package com.service.serviceImpl;

import com.comparators.vacancyComparator;
import com.model.Vacancy;
import com.repository.VacancyRepository;
import com.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
@Service
public class VacancyServiceImpl implements VacancyService {
    private final VacancyRepository vacancyRepository;
    @Autowired
    public VacancyServiceImpl(VacancyRepository vacancyRepository){
        this.vacancyRepository = vacancyRepository;
    }

    @Override
    public Vacancy addAndUpdateVacancy(Vacancy vacancy){
        return vacancyRepository.save(vacancy);
    }
    @Override
    public List<Vacancy> getVacancies(){
        List<Vacancy> vacancies=vacancyRepository.findAll();
        vacancies.sort(new vacancyComparator());
        return vacancies;
    }

    @Override
    public Vacancy findVacancyById(int id){

        return vacancyRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteVacancy(int id){
        vacancyRepository.deleteById(id);
    }
}
