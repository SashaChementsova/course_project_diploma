package com.service;

import com.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee addAndUpdateEmployee(Employee employee);
    public List<Employee> getEmployees();

    public Employee findEmployeeById(int id);
    public void deleteEmployee(int id);
}
