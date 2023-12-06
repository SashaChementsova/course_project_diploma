package com.service.serviceImpl;

import com.comparators.positionNameComparator;
import com.model.Department;
import com.model.Employee;
import com.model.Position;
import com.model.PositionName;
import com.repository.DepartmentRepository;
import com.repository.EmployeeRepository;
import com.repository.PositionNameRepository;
import com.repository.PositionRepository;
import com.service.EmployeeService;
import com.service.PositionNameService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PositionNameServiceImpl implements PositionNameService {
    private final PositionNameRepository positionNameRepository;
    private final PositionRepository positionRepository;

    private final EmployeeService employeeService;
    private final DepartmentRepository departmentRepository;
    @Autowired
    public PositionNameServiceImpl(PositionNameRepository positionNameRepository, DepartmentRepository departmentRepository, PositionRepository positionRepository, EmployeeService employeeService){
        this.positionNameRepository = positionNameRepository;
        this.departmentRepository=departmentRepository;
        this.positionRepository=positionRepository;
        this.employeeService=employeeService;
    }
    @Override
    public PositionName addAndUpdatePositionName(PositionName positionName){
        return positionNameRepository.save(positionName);
    }
    @Override
    public List<PositionName> getPositionNames(){
        List<PositionName> positionNames = positionNameRepository.findAll();
        positionNames.sort(new positionNameComparator());
        return positionNames;
    }
    @Override
    public PositionName findPositionNameById(int id){

        return positionNameRepository.findById(id).orElse(null);
    }
    @Override
    public void deletePositionName(int id){
        positionNameRepository.deleteById(id);
    }

    @Override
    public void initializePositionName(){
        try {
            Department department= departmentRepository.save(new Department("Отдел кадров"));
            positionNameRepository.save(new PositionName("HR-менеджер",department));
        }
        catch (Exception ex){
            System.out.println("Значения уже есть");
        }
    }
    @Override
    public List<Employee> getEmployees(int id){
        PositionName positionName=positionNameRepository.findById(id).orElse(null);
        if(positionName==null) return null;
        List<Employee> allEmployees=employeeService.getEmployees();
        List<Employee> employees=new ArrayList<>();
        for(Employee empl:allEmployees){
            if(empl.getPosition().getPositionName().getName().equals(positionName.getName())){
                employees.add(empl);
            }
        }
        return employees;

    }

}
