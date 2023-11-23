package com.service.serviceImpl;

import com.model.AdminEntity;
import com.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl {
    private final AdminRepository adminRepository;
    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository){
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