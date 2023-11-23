package com.service;

import com.model.OrganizationalAndLegalFormEntity;
import com.repository.OrganizationalAndLegalFormRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrganizationalAndLegalFormService {
    private final OrganizationalAndLegalFormRepository organizationalAndLegalFormRepository;
    @Autowired
    public OrganizationalAndLegalFormService(OrganizationalAndLegalFormRepository organizationalAndLegalFormRepository){
        this.organizationalAndLegalFormRepository = organizationalAndLegalFormRepository;
    }

    public OrganizationalAndLegalFormEntity addAndUpdateOrganizationalAndLegalForm(OrganizationalAndLegalFormEntity organizationalAndLegalFormEntity){
        return organizationalAndLegalFormRepository.save(organizationalAndLegalFormEntity);
    }
    public List<OrganizationalAndLegalFormEntity> getOrganizationalAndLegalForms(){
        return organizationalAndLegalFormRepository.findAll();
    }

    public OrganizationalAndLegalFormEntity findOrganizationalAndLegalFormById(int id){

        return organizationalAndLegalFormRepository.findById(id).orElse(null);
    }
    public void deleteOrganizationalAndLegalForm(int id){
        organizationalAndLegalFormRepository.deleteById(id);
    }
}
