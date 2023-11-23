package com.service;

import com.model.CityCompanyEntity;
import com.repository.CityCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityCompanyService {
    private final CityCompanyRepository cityCompanyRepository;
    @Autowired
    public CityCompanyService(CityCompanyRepository cityCompanyRepository){
        this.cityCompanyRepository = cityCompanyRepository;
    }

    public CityCompanyEntity addAndUpdateCityCompany(CityCompanyEntity cityCompanyEntity){
        return cityCompanyRepository.save(cityCompanyEntity);
    }
    public List<CityCompanyEntity> getCityCompanies(){
        return cityCompanyRepository.findAll();
    }

    public CityCompanyEntity findCityCompanyById(int id){

        return cityCompanyRepository.findById(id).orElse(null);
    }
    public void deleteCityCompany(int id){
        cityCompanyRepository.deleteById(id);
    }
}
