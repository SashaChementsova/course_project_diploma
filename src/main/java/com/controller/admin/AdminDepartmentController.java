package com.controller.admin;

import com.model.Department;
import com.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminDepartmentController {

    DepartmentService departmentService;

    public AdminDepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/admin/departments")
    public String getDepartments(Model model){

        checkDepartments();
        model.addAttribute("departments", departmentService.getDepartments());
        if(departmentService.getDepartments().isEmpty()) model.addAttribute("emptiness","empty");
        return "admin/departmentControl/getDepartments.html";
    }

    @GetMapping("/admin/addDep")
    public String addDepartment(Model model){
        checkDepartments();
        model.addAttribute("department", new Department());
        model.addAttribute("add","add");
        model.addAttribute("departments", departmentService.getDepartments());
        if(departmentService.getDepartments().isEmpty()) model.addAttribute("emptiness","empty");
        return "admin/departmentControl/getDepartments.html";
    }

    @PostMapping("/admin/addDep/end")
    public String addDepartmentEnd(Department department, Model model){
        try{
            departmentService.addAndUpdateDepartment(department);
        }
        catch (Exception ex){
            model.addAttribute("department", department);
            model.addAttribute("add","add");
            model.addAttribute("fail","fail");
            model.addAttribute("departments", departmentService.getDepartments());
            if(departmentService.getDepartments().isEmpty()) model.addAttribute("emptiness","empty");

            return "admin/positionControl/getPositions.html";
        }
        return "redirect:/admin/departments";
    }

    @GetMapping("/admin/editDep/{id}")
    public String editDepartment(@PathVariable("id") String id, Model model){
        checkDepartments();
        model.addAttribute("edit","edit");
        model.addAttribute("department1", departmentService.findDepartmentById(Integer.parseInt(id)));
        model.addAttribute("departments", departmentService.getDepartments());
        return "admin/departmentControl/getDepartments.html";
    }

    @PostMapping("/admin/editDep/end")
    public String editDepartmentEnd(Department department, Model model){
        System.out.println(department.getIdDepartment());
        try {
            departmentService.addAndUpdateDepartment(department);
        }
        catch (Exception ex){
            model.addAttribute("department1", department);
            model.addAttribute("edit","edit");
            model.addAttribute("fail1","fail1");
            model.addAttribute("departments", departmentService.getDepartments());
            return "admin/departmentControl/getDepartments.html";
        }
        return "redirect:/admin/departments";
    }

    private void checkDepartments(){
        if(departmentService.getDepartments().isEmpty()) departmentService.initializeDepartment();
    }
}
