package com.controller.hr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HrMainPageController {
    @GetMapping("/hr/hrHome")
    public String hrHome(Model model){
        return "hr.html";
    }
}
