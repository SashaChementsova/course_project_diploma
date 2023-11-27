package com.controller.admin;

import com.dto.UserDto;
import com.model.*;
import com.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.regex.Pattern;

@Controller
public class AdminEmployeeController {
    EmployeeService employeeService;
    HrService hrService;
    ImageService imageService;
    UserDetailService userDetailService;
    PositionNameService positionNameService;
    LevelPositionService levelPositionService;
    PositionService positionService;
    CityCompanyService cityCompanyService;


    public AdminEmployeeController(EmployeeService employeeService, HrService hrService, ImageService imageService, UserDetailService userDetailService, PositionNameService positionNameService, LevelPositionService levelPositionService, PositionService positionService, CityCompanyService cityCompanyService) {
        this.employeeService = employeeService;
        this.hrService = hrService;
        this.imageService = imageService;
        this.userDetailService = userDetailService;
        this.positionNameService = positionNameService;
        this.levelPositionService = levelPositionService;
        this.positionService = positionService;
        this.cityCompanyService = cityCompanyService;
    }

    @GetMapping("/admin/employees")
    public String getEmployees(Model model){
        checkPositions();
        checkCityAndAddress();
        model.addAttribute("employees", employeeService.getEmployees());
        if(employeeService.getEmployees().isEmpty())model.addAttribute("emptiness","empty");
        return "admin/employeeControl/getEmployees.html";
    }

    @GetMapping("/admin/addEmployee/start")
    public String addEmployee(Model model){
        checkPositions();
        checkCityAndAddress();
        model.addAttribute("positions", positionNameService.getPositionNames());
        model.addAttribute("levelPositions", levelPositionService.getLevelPositions());
        model.addAttribute("cities",cityCompanyService.getCityCompanies());
        model.addAttribute("user",new UserDetail());
        model.addAttribute("levelPosition",new LevelPosition());
        model.addAttribute("position",new PositionName());
        model.addAttribute("city",new CityCompany());
        model.addAttribute("employee",new Employee());
        return "admin/employeeControl/addEmployee.html";
    }


    @PostMapping("/admin/addEmployee/end")
    public String addEmployeeEnd(UserDetail user, PositionName positionName, LevelPosition levelPosition,CityCompany cityCompany, Employee employee, Model model, BindingResult result) throws IOException {
        checkPositions();
        checkCityAndAddress();
        if(checkEmptinessUser(user, positionName, levelPosition, cityCompany,employee,model)) return "admin/employeeControl/addEmployee.html";
        if(checkEmail(user, positionName, levelPosition, cityCompany,employee,model)) return "admin/employeeControl/addEmployee.html";
        if(checkPassword(user, positionName, levelPosition, cityCompany,employee,model)) return "admin/employeeControl/addEmployee.html";
        if(checkExistingPhone(user, positionName, levelPosition, cityCompany,employee,model)){return "registerEnd.html";}
        UserDetail existingUser = userDetailService.findUserByEmail(user.getEmail());
        if(checkUserExisting(user, positionName, levelPosition, cityCompany,employee,existingUser,model)) return "admin/employeeControl/addEmployee.html";
        if(checkUserAge(user, positionName, levelPosition, cityCompany,employee,model)) {return "admin/employeeControl/addEmployee.html";}
        if(checkEmployeeDates(user, positionName, levelPosition, cityCompany,employee, model)) {return "admin/employeeControl/addEmployee.html";}
        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "admin/employeeControl/addEmployee.html";
        }
        if(user.getPatronymic().isEmpty()){user.setPatronymic("-");}
        if(user.getInfo().isEmpty()){user.setInfo("-");}
        userDetailService.saveUser(user,"ROLE_EMPLOYEE");
        Position position=new Position();
        position.setLevelPosition(levelPositionService.findLevelPositionById(levelPosition.getIdLevelPosition()));
        position.setPositionName(positionNameService.findPositionNameById(positionName.getIdPositionName()));
        position=positionService.addAndUpdatePosition(position);
        employee.setCityCompany(cityCompanyService.findCityCompanyById(cityCompany.getIdCityCompany()));
        employee.setPosition(position);
        employee.setUserDetail(user);
        employeeService.addAndUpdateEmployee(employee);
        if(position.getPositionName().getName().equals("HR-менеджер")){
            Hr hr=new Hr();
            hr.setUserDetail(user);
            hrService.addAndUpdateHr(hr);
        }
        return "redirect:/admin/employees";
    }
    private void checkPositions(){
        if(positionNameService.getPositionNames().isEmpty()) positionNameService.initializePositionName();
        if(levelPositionService.getLevelPositions().isEmpty()) levelPositionService.initializeLevelPosition();
    }
    private void checkCityAndAddress(){
        if(cityCompanyService.getCityCompanies().isEmpty()){
            cityCompanyService.initializeCityCompany();
        }
    }


    public boolean checkUserExisting(UserDetail user, PositionName positionName, LevelPosition levelPosition,CityCompany cityCompany, Employee employee, UserDetail existingUser, Model model){
        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            model.addAttribute("userExist","userExist");
            model.addAttribute("positions", positionNameService.getPositionNames());
            model.addAttribute("levelPositions", levelPositionService.getLevelPositions());
            model.addAttribute("cities",cityCompanyService.getCityCompanies());
            model.addAttribute("user",user);
            model.addAttribute("levelPosition",levelPosition);
            model.addAttribute("position",positionName);
            model.addAttribute("city",cityCompany);
            model.addAttribute("employee",employee);
            return true;
        }
        return false;
    }
    public boolean checkPassword(UserDetail user, PositionName positionName, LevelPosition levelPosition,CityCompany cityCompany, Employee employee, Model model){
        final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";
//        ^                  # start of the string
//        (?=.*[0-9])        # a digit must occur at least once
//                (?=.*[a-z])        # a lower case letter must occur at least once
//        (?=.*[A-Z])        # an upper case letter must occur at least once
//        (?=.*[@#$%^&+=])   # a special character must occur at least once
//        (?=\\S+$)          # no whitespace allowed in the entire string
//                .{8,16}            # 8-16 character password, both inclusive
//        $                  # end of the string
        final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);
        if (!(PASSWORD_PATTERN.matcher(user.getPassword()).matches())){
            model.addAttribute("positions", positionNameService.getPositionNames());
            model.addAttribute("levelPositions", levelPositionService.getLevelPositions());
            model.addAttribute("cities",cityCompanyService.getCityCompanies());
            model.addAttribute("user",user);
            model.addAttribute("levelPosition",levelPosition);
            model.addAttribute("position",positionName);
            model.addAttribute("city",cityCompany);
            model.addAttribute("employee",employee);
            model.addAttribute("wrongPassword","wrongPassword");
            return true;
        }
        return false;
    }
    public boolean checkEmail(UserDetail user, PositionName positionName, LevelPosition levelPosition,CityCompany cityCompany, Employee employee, Model model){
        final String PASSWORD_REGEX = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);
        if (!(PASSWORD_PATTERN.matcher(user.getEmail()).matches())){
            model.addAttribute("positions", positionNameService.getPositionNames());
            model.addAttribute("levelPositions", levelPositionService.getLevelPositions());
            model.addAttribute("cities",cityCompanyService.getCityCompanies());
            model.addAttribute("user",user);
            model.addAttribute("levelPosition",levelPosition);
            model.addAttribute("position",positionName);
            model.addAttribute("city",cityCompany);
            model.addAttribute("employee",employee);
            model.addAttribute("wrongEmail","wrongEmail");
            return true;
        }
        return false;
    }
    public boolean checkEmptinessUser(UserDetail user, PositionName positionName, LevelPosition levelPosition,CityCompany cityCompany, Employee employee, Model model){
        String dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthday());
        if (user.getPassword().equals("")|| user.getEmail().equals("") ||user.getName().equals("") || user.getSurname().equals("") ||  dateOfBirth.equals("") || user.getPhone().equals("")){
            model.addAttribute("positions", positionNameService.getPositionNames());
            model.addAttribute("levelPositions", levelPositionService.getLevelPositions());
            model.addAttribute("cities",cityCompanyService.getCityCompanies());
            model.addAttribute("user",user);
            model.addAttribute("levelPosition",levelPosition);
            model.addAttribute("position",positionName);
            model.addAttribute("city",cityCompany);
            model.addAttribute("employee",employee);
            model.addAttribute("empty","empty");
            return true;
        }
        return false;
    }
    public boolean checkUserAge(UserDetail user, PositionName positionName, LevelPosition levelPosition,CityCompany cityCompany, Employee employee, Model model) {
        String dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthday());
        int age= userDetailService.calculateAge(dateOfBirth);
        if(age<18) {
            model.addAttribute("age", "age");
            model.addAttribute("positions", positionNameService.getPositionNames());
            model.addAttribute("levelPositions", levelPositionService.getLevelPositions());
            model.addAttribute("cities",cityCompanyService.getCityCompanies());
            model.addAttribute("user",user);
            model.addAttribute("levelPosition",levelPosition);
            model.addAttribute("position",positionName);
            model.addAttribute("city",cityCompany);
            model.addAttribute("employee",employee);
            return true;
        }
        return false;
    }
    public boolean checkExistingPhone(UserDetail user, PositionName positionName, LevelPosition levelPosition,CityCompany cityCompany, Employee employee, Model model){
        if(userDetailService.findUserByPhone(user.getPhone())!=null) {
            model.addAttribute("existPhone", "existPhone");
            model.addAttribute("positions", positionNameService.getPositionNames());
            model.addAttribute("levelPositions", levelPositionService.getLevelPositions());
            model.addAttribute("cities",cityCompanyService.getCityCompanies());
            model.addAttribute("user",user);
            model.addAttribute("levelPosition",levelPosition);
            model.addAttribute("position",positionName);
            model.addAttribute("city",cityCompany);
            model.addAttribute("employee",employee);
            return true;
        }
        return false;
    }
    public boolean checkEmployeeDates(UserDetail user, PositionName positionName, LevelPosition levelPosition,CityCompany cityCompany, Employee employee, Model model) {
        model.addAttribute("positions", positionNameService.getPositionNames());
        model.addAttribute("levelPositions", levelPositionService.getLevelPositions());
        model.addAttribute("cities",cityCompanyService.getCityCompanies());
        model.addAttribute("user",user);
        model.addAttribute("levelPosition",levelPosition);
        model.addAttribute("position",positionName);
        model.addAttribute("city",cityCompany);
        model.addAttribute("employee",employee);
        int res1=employeeService.compareDates(new SimpleDateFormat("yyyy-MM-dd").format(employee.getDateRecruitment()),new SimpleDateFormat("yyyy-MM-dd").format(employee.getDateContractEnd()));
        if(res1==0){
            model.addAttribute("equalDates","equalDates");
            return true;
        }
        int res2=employeeService.compareDates(new SimpleDateFormat("yyyy-MM-dd").format(employee.getDateRecruitment()),new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
        if(res2>0){
            model.addAttribute("failDateBegin","failDateBegin");
            return true;
        }
        int res3=employeeService.compareDates(new SimpleDateFormat("yyyy-MM-dd").format(employee.getDateContractEnd()),new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
        if(res3<0){
            model.addAttribute("failDateEnd","failDateEnd");
            return true;
        }
        int res4=employeeService.calculateDifferenceDates(employee);
        System.out.println("res4 " +res4);
        if(!(1<=res4&&res4<=5)){
            model.addAttribute("diffDates","diffDates");
            return true;
        }
        return false;
    }

}
