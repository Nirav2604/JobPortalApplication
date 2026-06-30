package com.Portal.JobPortalApplication.controller;

import com.Portal.JobPortalApplication.service.ApplicationService;
import com.Portal.JobPortalApplication.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CandidatePageController {

    private final JobService jobService;
    private final ApplicationService applicationService;
    @GetMapping("/candidate/dashboard")
    public String dashboard(Authentication authentication) {

        System.out.println(authentication);

        return "candidate/dashboard";
    }
    @GetMapping("/candidate/profile")
    public String profile() {
        return "candidate/profile";
    }

    @GetMapping("/candidate/search-jobs")
    public String searchJobs(Model model){

        model.addAttribute("jobs", jobService.getAllJobs());

        return "candidate/search-jobs";
    }
    @GetMapping("/candidate/applications")
    public String applications( Authentication authentication,Model model){
        String email=authentication.getName();
        model.addAttribute("applications", applicationService.getMyApplications(email));
        return "candidate/applications";
    }

}