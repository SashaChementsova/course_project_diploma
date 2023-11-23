package com.service;

import com.model.AddressCompanyEntity;
import com.repository.AddressCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AddressCompanyService {
    private final AddressCompanyRepository addressCompanyRepository;
    @Autowired
    public AddressCompanyService(AddressCompanyRepository addressCompanyRepository){
        this.addressCompanyRepository = addressCompanyRepository;
    }

    public AddressCompanyEntity addAndUpdateAddressCompany(AddressCompanyEntity addressCompanyEntity){
        return addressCompanyRepository.save(addressCompanyEntity);
    }
    public List<AddressCompanyEntity> getAddressCompanies(){
        return addressCompanyRepository.findAll();
    }

    public AddressCompanyEntity findAddressCompanyById(int id){

        return addressCompanyRepository.findById(id).orElse(null);
    }
    public void deleteAddressCompany(int id){
        addressCompanyRepository.deleteById(id);
    }
}
