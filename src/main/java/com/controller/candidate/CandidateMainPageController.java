package com.controller.candidate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CandidateMainPageController {
    @GetMapping("/candidate/candidateHome")
    public String candidateHome(Model model){
        return "candidate.html";
    }

}
