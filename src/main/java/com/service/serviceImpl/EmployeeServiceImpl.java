package com.service.serviceImpl;

import com.model.Employee;
import com.repository.EmployeeRepository;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee addAndUpdateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    @Override
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }
    @Override
    public Employee findEmployeeById(int id){

        return employeeRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteEmployee(int id){
        employeeRepository.deleteById(id);
    }
}
