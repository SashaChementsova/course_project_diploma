package com.service;

import com.model.RoleEntity;
import com.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleService {
    private final RoleRepository roleRepository;
    @Autowired
    public RoleService(RoleRepository roleRepository){
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
