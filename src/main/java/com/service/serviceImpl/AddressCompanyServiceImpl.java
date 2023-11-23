package com.service.serviceImpl;

import com.model.AddressCompany;
import com.repository.AddressCompanyRepository;
import com.service.AddressCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressCompanyServiceImpl implements AddressCompanyService {
    private final AddressCompanyRepository addressCompanyRepository;
    @Autowired
    public AddressCompanyServiceImpl(AddressCompanyRepository addressCompanyRepository){
        this.addressCompanyRepository = addressCompanyRepository;
    }
    @Override
    public AddressCompany addAndUpdateAddressCompany(AddressCompany addressCompany){
        return addressCompanyRepository.save(addressCompany);
    }
    @Override
    public List<AddressCompany> getAddressCompanies(){
        return addressCompanyRepository.findAll();
    }
    @Override
    public AddressCompany findAddressCompanyById(int id){

        return addressCompanyRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteAddressCompany(int id){
        addressCompanyRepository.deleteById(id);
    }
}
