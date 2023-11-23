package com.service.serviceImpl;

import com.model.CityCompanyEntity;
import com.repository.CityCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityCompanyServiceImpl {
    private final CityCompanyRepository cityCompanyRepository;
    @Autowired
    public CityCompanyServiceImpl(CityCompanyRepository cityCompanyRepository){
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
