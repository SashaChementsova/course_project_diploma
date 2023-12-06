package com.service.serviceImpl;

import com.comparators.departmentComparator;
import com.model.Department;
import com.model.PositionName;
import com.repository.DepartmentRepository;
import com.repository.PositionNameRepository;
import com.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final PositionNameRepository positionNameRepository;
    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository,PositionNameRepository positionNameRepository){
        this.departmentRepository = departmentRepository;
        this.positionNameRepository=positionNameRepository;
    }
    @Override
    public Department addAndUpdateDepartment(Department department){
        return departmentRepository.save(department);
    }
    @Override
    public List<Department> getDepartments(){
        List<Department> departments = departmentRepository.findAll();
        departments.sort(new departmentComparator());
        return departments;
    }
    @Override
    public Department findDepartmentById(int id){

        return departmentRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteDepartment(int id){
        departmentRepository.deleteById(id);
    }

    @Override
    public void initializeDepartment(){
        try {

            Department department= departmentRepository.save(new Department("Отдел кадров"));
            positionNameRepository.save(new PositionName("HR-менеджер",department));
        }
        catch (Exception ex){
            System.out.println("Значения уже есть");
        }
    }
}
