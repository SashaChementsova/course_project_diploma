package com.controller.hr;

import com.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HrMainPageController {
    private final HrService hrService;
    @Autowired
    public HrMainPageController(HrService hrService) {
        this.hrService = hrService;
    }

    @GetMapping("/hr/hrPage")
    public String hrHome(Model model){
        return "hr/hr.html";
    }

}
