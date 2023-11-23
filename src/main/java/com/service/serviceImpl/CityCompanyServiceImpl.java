package com.service.serviceImpl;

import com.model.CityCompany;
import com.repository.CityCompanyRepository;
import com.service.CityCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityCompanyServiceImpl implements CityCompanyService {
    private final CityCompanyRepository cityCompanyRepository;
    @Autowired
    public CityCompanyServiceImpl(CityCompanyRepository cityCompanyRepository){
        this.cityCompanyRepository = cityCompanyRepository;
    }
    @Override
    public CityCompany addAndUpdateCityCompany(CityCompany cityCompany){
        return cityCompanyRepository.save(cityCompany);
    }
    @Override
    public List<CityCompany> getCityCompanies(){
        return cityCompanyRepository.findAll();
    }
    @Override
    public CityCompany findCityCompanyById(int id){

        return cityCompanyRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteCityCompany(int id){
        cityCompanyRepository.deleteById(id);
    }
}
