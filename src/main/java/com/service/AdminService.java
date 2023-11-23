package com.service;

import com.model.AdminEntity;
import com.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdminService {
    private final AdminRepository adminRepository;
    @Autowired
    public AdminService(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    public AdminEntity addAndUpdateAdmin(AdminEntity adminEntity){
        return adminRepository.save(adminEntity);
    }
    public List<AdminEntity> getAdmins(){
        return adminRepository.findAll();
    }

    public AdminEntity findAdminById(int id){

        return adminRepository.findById(id).orElse(null);
    }
    public void deleteAdmin(int id){
        adminRepository.deleteById(id);
    }
}
