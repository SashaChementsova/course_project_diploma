package com.service.serviceImpl;

import com.model.OrganizationalAndLegalFormEntity;
import com.repository.OrganizationalAndLegalFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrganizationalAndLegalFormServiceImpl {
    private final OrganizationalAndLegalFormRepository organizationalAndLegalFormRepository;
    @Autowired
    public OrganizationalAndLegalFormServiceImpl(OrganizationalAndLegalFormRepository organizationalAndLegalFormRepository){
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