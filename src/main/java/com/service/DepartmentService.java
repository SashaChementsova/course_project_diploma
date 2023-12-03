package com.service;


import com.model.Department;

import java.util.List;

public interface DepartmentService {

    public Department addAndUpdateDepartment(Department department);
    public List<Department> getDepartments();

    public Department findDepartmentById(int id);
    public void deleteDepartment(int id);

    public void initializeDepartment();
}
