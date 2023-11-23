package com.service.serviceImpl;

import com.model.RoleEntity;
import com.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl {
    private final RoleRepository roleRepository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public RoleEntity addAndUpdateRole(RoleEntity role){
        return roleRepository.save(role);
    }
    public List<RoleEntity> getRoles(){
        return roleRepository.findAll();
    }

    public RoleEntity findRoleById(int id){

        return roleRepository.findById(id).orElse(null);
    }
    public void deleteRole(int id){
        roleRepository.deleteById(id);
    }
}