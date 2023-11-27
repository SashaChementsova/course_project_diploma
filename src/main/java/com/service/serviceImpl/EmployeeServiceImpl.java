package com.service.serviceImpl;

import com.model.Employee;
import com.repository.EmployeeRepository;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Override
    public int calculateDifferenceDates(Employee employee){
        int age=0;
        String date1 = new SimpleDateFormat("yyyy-MM-dd").format(employee.getDateRecruitment());
        String date2 = new SimpleDateFormat("yyyy-MM-dd").format(employee.getDateContractEnd());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne = null;
        Date dateTwo = null;
        try {
            dateOne = format.parse(date1);
            dateTwo = format.parse(date2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Количество дней между датами в миллисекундах
        long difference = dateTwo.getTime() - dateOne.getTime();
        // Перевод количества дней между датами из миллисекунд в дни
        double days = difference / (24 * 60 * 60 * 1000); // миллисекунды / (24ч * 60мин * 60сек * 1000мс)
        double years=days/365;
        age= (int) Math.floor(years);
        return age;
    }

    @Override
    public int compareDates(String date1,String date2){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne = null;
        Date dateTwo = null;
        try {
            dateOne = format.parse(date1);
            dateTwo = format.parse(date2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateOne.compareTo(dateTwo);
    }

}
