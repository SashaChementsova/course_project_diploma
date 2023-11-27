package com.controller.candidate;

import com.model.UserDetail;
import com.service.ImageService;;
import com.service.UserDetailService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CandidateProfileController {
    private UserDetailService userDetailService;
    private ImageService imageService;

    public CandidateProfileController(UserDetailService userDetailService, ImageService imageService) {
        this.userDetailService = userDetailService;
        this.imageService = imageService;
    }

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    public String getCurrentUsernameRoles() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role=auth.getAuthorities().toString();
        role=role.replace('[',' ');
        role=role.replace(']',' ');
        role=role.trim();
        return role;
    }

    @GetMapping("/candidate/candidateProfile")
    public String userProfile(Model model){
        model.addAttribute("user", userDetailService.findUserByEmail(getCurrentUsername()));
        System.out.println(userDetailService.findUserByEmail(getCurrentUsername()).getImage().getIdImage());
        model.addAttribute("photo",userDetailService.findUserByEmail(getCurrentUsername()).getImage());
        return "candidate/candidateProfile.html";
    }
}
