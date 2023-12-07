package com.service.serviceImpl;

import com.comparators.vacancyComparator;
import com.model.Hr;
import com.model.Position;
import com.model.PositionName;
import com.model.Vacancy;
import com.repository.VacancyRepository;
import com.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Override
    public void deleteVacancyByPositionName(PositionName positionName){
        List<Vacancy> vacancies=getVacanciesByPositionName(positionName);
        if(vacancies!=null){
            if(!(vacancies.isEmpty())){
                for(Vacancy vacancy:vacancies){
                    vacancy.setPosition(null);
                    addAndUpdateVacancy(vacancy);
                }
            }
        }
    }

    @Override
    public List<Vacancy> getVacanciesByPositionName(PositionName positionName){
        List<Position> positions=positionName.getPositionEntities();
        List<Vacancy> allVacancies;
        List<Vacancy> vacancies=new ArrayList<>();
        for(Position position:positions){
            allVacancies=position.getVacancyEntities();
            if(allVacancies!=null){
                if(!(allVacancies.isEmpty())){
                    for(Vacancy vacancy:allVacancies){
                        if(vacancy.getPosition().getPositionName().getIdPositionName()==positionName.getIdPositionName()){
                            vacancies.add(vacancy);
                        }
                    }
                }
            }
        }
        return vacancies;
    }

    @Override
    public void deleteVacancyByHr(Hr hr){
        List<Vacancy> vacancies=hr.getVacancyEntities();
        if(vacancies!=null){
            if(!(vacancies.isEmpty())){
                for (Vacancy vacancy:vacancies){
                    vacancy.setHr(null);
                    addAndUpdateVacancy(vacancy);
                }
            }
        }
    }

}
