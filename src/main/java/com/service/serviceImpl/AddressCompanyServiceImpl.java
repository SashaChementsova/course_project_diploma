package com.service.serviceImpl;

import com.model.AddressCompanyEntity;
import com.repository.AddressCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressCompanyServiceImpl {
    private final AddressCompanyRepository addressCompanyRepository;
    @Autowired
    public AddressCompanyServiceImpl(AddressCompanyRepository addressCompanyRepository){
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
