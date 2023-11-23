package com.repository;

import com.model.AddressCompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressCompanyRepository extends JpaRepository<AddressCompanyEntity,Integer> {
}
