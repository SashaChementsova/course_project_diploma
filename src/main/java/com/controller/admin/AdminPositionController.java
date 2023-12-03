package com.controller.admin;

import com.model.Department;
import com.model.LevelPosition;
import com.model.PositionName;
import com.service.DepartmentService;
import com.service.LevelPositionService;
import com.service.PositionNameService;
import com.service.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminPositionController {
    PositionNameService positionNameService;
    LevelPositionService levelPositionService;
    PositionService positionService;

    DepartmentService departmentService;
    public AdminPositionController(PositionNameService positionNameService, LevelPositionService levelPositionService, PositionService positionService,DepartmentService departmentService) {
        this.positionNameService = positionNameService;
        this.levelPositionService = levelPositionService;
        this.positionService = positionService;
        this.departmentService=departmentService;
    }

    @GetMapping("/admin/positions")
    public String getPositions(Model model){
        checkPositions();
        model.addAttribute("positions", positionNameService.getPositionNames());
        if(positionNameService.getPositionNames().isEmpty()) model.addAttribute("emptiness","empty");
        return "admin/positionControl/getPositions.html";
    }

    @GetMapping("/admin/positions/{id}")
    public String getPositionsOfDepartment(@PathVariable("id") String id,Model model){
        checkPositions();
        model.addAttribute("positions",departmentService.findDepartmentById(Integer.parseInt(id)).getPositionNameEntities());
        model.addAttribute("departmentMain",departmentService.findDepartmentById(Integer.parseInt(id)));
        if(departmentService.findDepartmentById(Integer.parseInt(id)).getPositionNameEntities().isEmpty()) model.addAttribute("emptiness","empty");
        return "admin/positionControl/getPositionsOfDepartment.html";
    }

    @GetMapping("/admin/addPosition")
    public String addPosition(Model model){
        checkPositions();
        model.addAttribute("position", new PositionName());
        model.addAttribute("add","add");
        model.addAttribute("positions", positionNameService.getPositionNames());
        if(positionNameService.getPositionNames().isEmpty()) model.addAttribute("emptiness","empty");
        return "admin/positionControl/getPositions.html";
    }


    @PostMapping("/admin/addPosition/end")
    public String addPositionEnd(PositionName positionName, Model model){
        try{
            positionNameService.addAndUpdatePositionName(positionName);
        }
        catch (Exception ex){
            model.addAttribute("position", positionName);
            model.addAttribute("add","add");
            model.addAttribute("fail","fail");
            model.addAttribute("positions", positionNameService.getPositionNames());
            if(positionNameService.getPositionNames().isEmpty()) model.addAttribute("emptiness","empty");
            return "admin/positionControl/getPositions.html";
        }
        return "redirect:/admin/positions";
    }

    @GetMapping("/admin/editPosition/{id}")
    public String editPosition(@PathVariable("id") String id, Model model){
        System.out.println(id);
        checkPositions();
        model.addAttribute("edit","edit");
        model.addAttribute("position", positionNameService.findPositionNameById(Integer.parseInt(id)));
        model.addAttribute("positions", positionNameService.getPositionNames());
        return "admin/positionControl/getPositions.html";
    }

    @PostMapping("/admin/editPosition/end")
    public String editPositionEnd(PositionName positionName, Model model){
        try {
            positionNameService.addAndUpdatePositionName(positionName);
        }
        catch (Exception ex){
            System.out.println(positionName.getName());
            model.addAttribute("edit","edit");
            model.addAttribute("position", positionName);
            model.addAttribute("fail1","fail1");
            model.addAttribute("positions", positionNameService.getPositionNames());
            return "admin/positionControl/getPositions.html";
        }
        return "redirect:/admin/positions/";
    }

    @GetMapping("/admin/addPosDep/{id}")
    public String addPositionDep(@PathVariable("id") String id, Model model){
        checkPositions();
        model.addAttribute("position", new PositionName());
        model.addAttribute("add","add");
        model.addAttribute("positions",departmentService.findDepartmentById(Integer.parseInt(id)).getPositionNameEntities());
        model.addAttribute("departmentMain",departmentService.findDepartmentById(Integer.parseInt(id)));
        if(departmentService.findDepartmentById(Integer.parseInt(id)).getPositionNameEntities().isEmpty()) model.addAttribute("emptiness","empty");
        return "admin/positionControl/getPositionsOfDepartment.html";
    }


    @PostMapping("/admin/addPosDep/end/{id}")
    public String addPositionDepEnd(@PathVariable("id") String idDepartment,PositionName positionName, Model model){
        try{
            positionName.setDepartment(departmentService.findDepartmentById(Integer.parseInt(idDepartment)));
            positionNameService.addAndUpdatePositionName(positionName);
        }
        catch (Exception ex){
            model.addAttribute("position", positionName);
            model.addAttribute("add","add");
            model.addAttribute("fail","fail");
            model.addAttribute("positions",departmentService.findDepartmentById(Integer.parseInt(idDepartment)).getPositionNameEntities());
            model.addAttribute("departmentMain",departmentService.findDepartmentById(Integer.parseInt(idDepartment)));
            model.addAttribute("idDepartment", departmentService.findDepartmentById(Integer.parseInt(idDepartment)).getIdDepartment());
            if(departmentService.findDepartmentById(Integer.parseInt(idDepartment)).getPositionNameEntities().isEmpty()) model.addAttribute("emptiness","empty");
            return "admin/positionControl/getPositionsOfDepartment.html";
        }
        return "redirect:/admin/positions/"+idDepartment;
    }

    @GetMapping("/admin/editPosDep/{id}")
    public String editPositionDep(@PathVariable("id") String id, Model model){
        System.out.println(id);
        checkPositions();
        PositionName positionName=positionNameService.findPositionNameById(Integer.parseInt(id));
        model.addAttribute("edit","edit");
        model.addAttribute("position",positionName);
        model.addAttribute("positions",departmentService.findDepartmentById(positionName.getDepartment().getIdDepartment()).getPositionNameEntities());
        model.addAttribute("departmentMain",departmentService.findDepartmentById(positionName.getDepartment().getIdDepartment()));
        if(departmentService.findDepartmentById(positionName.getDepartment().getIdDepartment()).getPositionNameEntities().isEmpty()) model.addAttribute("emptiness","empty");
        return "admin/positionControl/getPositionsOfDepartment.html";
    }

    @PostMapping("/admin/editPosDeb/end/{id}")
    public String editPositionEndDep(@PathVariable("id") String id,PositionName positionName, Model model){
        System.out.println(positionName.getName());
        try {
            positionName.setDepartment(departmentService.findDepartmentById(Integer.parseInt(id)));
            positionNameService.addAndUpdatePositionName(positionName);
        }
        catch (Exception ex){
            System.out.println(positionName.getName());
            model.addAttribute("edit","edit");
            model.addAttribute("position", positionName);
            model.addAttribute("fail1","fail1");
            model.addAttribute("positions",departmentService.findDepartmentById(positionName.getDepartment().getIdDepartment()).getPositionNameEntities());
            model.addAttribute("departmentMain",departmentService.findDepartmentById(positionName.getDepartment().getIdDepartment()));
            if(departmentService.findDepartmentById(positionName.getDepartment().getIdDepartment()).getPositionNameEntities().isEmpty()) model.addAttribute("emptiness","empty");
            return "admin/positionControl/getPositionsOfDepartment.html";
        }
        return "redirect:/admin/positions/"+positionName.getDepartment().getIdDepartment();
    }

    private void checkPositions(){
        if(positionNameService.getPositionNames().isEmpty()) positionNameService.initializePositionName();
        if(levelPositionService.getLevelPositions().isEmpty()) levelPositionService.initializeLevelPosition();
    }

}
