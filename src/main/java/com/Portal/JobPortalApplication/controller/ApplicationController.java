package com.Portal.JobPortalApplication.controller;

import com.Portal.JobPortalApplication.dto.ApplicationStatusRequest;
import com.Portal.JobPortalApplication.entity.Application;
import com.Portal.JobPortalApplication.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping("/apply/{jobId}")
    public Application applyJob(@PathVariable Long jobId, Authentication authentication){
        return applicationService.applyJobs(jobId, authentication.getName());
    }

    @GetMapping("/myapplications")
    public List<Application> myApplications(Authentication authentication) {
        return applicationService.getMyApplications(authentication.getName());
    }
    @GetMapping("/job/{jobId}")
    public List<Application> applicants(@PathVariable Long jobId, Authentication authentication) {
        return applicationService.getApplicants(jobId, authentication.getName());
    }

    @PutMapping("/{applicationId}/status")
    public Application updateStatus(@PathVariable Long applicationId, @RequestBody ApplicationStatusRequest request, Authentication authentication) {
        return applicationService.updateStatus(applicationId, authentication.getName(), request.getApplicationStatus().name());
    }
}
