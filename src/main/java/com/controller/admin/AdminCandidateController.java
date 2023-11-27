package com.controller.admin;

import com.service.*;
import org.springframework.stereotype.Controller;

@Controller
public class AdminCandidateController {
    ImageService imageService;
    UserDetailService userDetailService;
    CandidateService candidateService;

    public AdminCandidateController(ImageService imageService, UserDetailService userDetailService, CandidateService candidateService) {
        this.imageService = imageService;
        this.userDetailService = userDetailService;
        this.candidateService = candidateService;
    }
}
