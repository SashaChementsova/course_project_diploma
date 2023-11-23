package com.service;

import com.model.Vacancy;

import java.util.List;

public interface VacancyService {
    public Vacancy addAndUpdateVacancy(Vacancy vacancy);
    public List<Vacancy> getVacancies();

    public Vacancy findVacancyById(int id);
    public void deleteVacancy(int id);
}
