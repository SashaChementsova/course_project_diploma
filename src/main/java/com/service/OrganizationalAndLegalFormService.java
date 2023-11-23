package com.service;

import com.model.OrganizationalAndLegalForm;

import java.util.List;

public interface OrganizationalAndLegalFormService {
    public OrganizationalAndLegalForm addAndUpdateOrganizationalAndLegalForm(OrganizationalAndLegalForm organizationalAndLegalForm);
    public List<OrganizationalAndLegalForm> getOrganizationalAndLegalForms();

    public OrganizationalAndLegalForm findOrganizationalAndLegalFormById(int id);
    public void deleteOrganizationalAndLegalForm(int id);
}
