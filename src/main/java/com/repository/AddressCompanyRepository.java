package com.repository;

import com.model.AddressCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressCompanyRepository extends JpaRepository<AddressCompany,Integer> {
}
