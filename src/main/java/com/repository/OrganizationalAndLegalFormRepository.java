package com.repository;

import com.model.OrganizationalAndLegalFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationalAndLegalFormRepository extends JpaRepository<OrganizationalAndLegalFormEntity,Integer> {
}
