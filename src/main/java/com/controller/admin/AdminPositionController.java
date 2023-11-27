package com.controller.admin;

import com.model.LevelPosition;
import com.model.PositionName;
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

    public AdminPositionController(PositionNameService positionNameService, LevelPositionService levelPositionService, PositionService positionService) {
        this.positionNameService = positionNameService;
        this.levelPositionService = levelPositionService;
        this.positionService = positionService;
    }

    @GetMapping("/admin/positions")
    public String getPositions(Model model){
        checkPositions();
        model.addAttribute("positions", positionNameService.getPositionNames());
        if(positionNameService.getPositionNames().isEmpty()) model.addAttribute("emptiness","empty");
        return "admin/positionControl/getPositions.html";
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
        return "redirect:/admin/positions";
    }

    private void checkPositions(){
        if(positionNameService.getPositionNames().isEmpty()) positionNameService.initializePositionName();
        if(levelPositionService.getLevelPositions().isEmpty()) levelPositionService.initializeLevelPosition();
    }

}
