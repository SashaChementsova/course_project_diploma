package com.service;

import com.model.AddressCompany;

import java.util.List;

public interface AddressCompanyService {
    public AddressCompany addAndUpdateAddressCompany(AddressCompany addressCompany);
    public List<AddressCompany> getAddressCompanies();
    public AddressCompany findAddressCompanyById(int id);
    public void deleteAddressCompany(int id);
}
