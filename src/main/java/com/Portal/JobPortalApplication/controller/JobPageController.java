package com.Portal.JobPortalApplication.controller;

import com.Portal.JobPortalApplication.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class JobPageController {

    private final JobService jobService;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("jobs", jobService.getLatestJobs());

        return "index";
    }

    @GetMapping("/jobs")
    public String jobs(Model model) {

        model.addAttribute("jobs", jobService.getAllJobs());

        return "jobs";
    }

    @GetMapping("/jobs/{id}")
    public String jobDetails(@PathVariable Long id,
                             Model model) {

        model.addAttribute("job", jobService.getJobById(id));

        return "job-details";
    }

}