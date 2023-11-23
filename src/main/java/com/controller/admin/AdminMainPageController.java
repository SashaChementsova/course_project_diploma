package com.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminMainPageController {
    @GetMapping("/admin/adminHome")
    public String adminHome(Model model){
        return "admin.html";
    }
}
