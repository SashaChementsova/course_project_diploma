package com.service.serviceImpl;

import com.model.OrganizationalAndLegalForm;
import com.repository.OrganizationalAndLegalFormRepository;
import com.service.OrganizationalAndLegalFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrganizationalAndLegalFormServiceImpl implements OrganizationalAndLegalFormService {
    private final OrganizationalAndLegalFormRepository organizationalAndLegalFormRepository;
    @Autowired
    public OrganizationalAndLegalFormServiceImpl(OrganizationalAndLegalFormRepository organizationalAndLegalFormRepository){
        this.organizationalAndLegalFormRepository = organizationalAndLegalFormRepository;
    }
    @Override
    public OrganizationalAndLegalForm addAndUpdateOrganizationalAndLegalForm(OrganizationalAndLegalForm organizationalAndLegalForm){
        return organizationalAndLegalFormRepository.save(organizationalAndLegalForm);
    }
    @Override
    public List<OrganizationalAndLegalForm> getOrganizationalAndLegalForms(){
        return organizationalAndLegalFormRepository.findAll();
    }
    @Override
    public OrganizationalAndLegalForm findOrganizationalAndLegalFormById(int id){

        return organizationalAndLegalFormRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteOrganizationalAndLegalForm(int id){
        organizationalAndLegalFormRepository.deleteById(id);
    }
}
