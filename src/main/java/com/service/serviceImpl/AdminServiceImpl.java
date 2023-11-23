package com.service.serviceImpl;

import com.model.Admin;
import com.repository.AdminRepository;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }
    @Override
    public Admin addAndUpdateAdmin(Admin admin){
        return adminRepository.save(admin);
    }
    @Override
    public List<Admin> getAdmins(){
        return adminRepository.findAll();
    }
    @Override
    public Admin findAdminById(int id){

        return adminRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteAdmin(int id){
        adminRepository.deleteById(id);
    }
}
