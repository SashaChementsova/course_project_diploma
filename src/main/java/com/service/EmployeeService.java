package com.service;

import com.model.EmployeeEntity;
import com.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity addAndUpdateEmployee(EmployeeEntity employeeEntity){
        return employeeRepository.save(employeeEntity);
    }
    public List<EmployeeEntity> getEmployees(){
        return employeeRepository.findAll();
    }

    public EmployeeEntity findEmployeeById(int id){

        return employeeRepository.findById(id).orElse(null);
    }
    public void deleteEmployee(int id){
        employeeRepository.deleteById(id);
    }
}
