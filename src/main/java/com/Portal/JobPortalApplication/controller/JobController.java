package com.Portal.JobPortalApplication.controller;

import com.Portal.JobPortalApplication.dto.JobRequest;
import com.Portal.JobPortalApplication.entity.Job;
import com.Portal.JobPortalApplication.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    @PostMapping
    public Job createJob(Authentication authentication, @RequestBody JobRequest jobRequest){
        return jobService.createJob(authentication.getName(), jobRequest);
    }

    @PutMapping("{/id}")
    public Job UpdateJob(@PathVariable Long id,Authentication authentication,@RequestBody JobRequest jobRequest){
        return jobService.updateJob(id, authentication.getName(), jobRequest);
    }

    @DeleteMapping("{/id}")
    public Job deleteJob(@PathVariable Long id,Authentication authentication){
        return jobService.deleteJob(id, authentication.getName());
    }

    @GetMapping
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id){
        return jobService.getJobById(id);
    }

    @GetMapping("/search")
    public List<Job> searchJobs(@RequestParam String keyword){
        return jobService.searchJobs(keyword);
    }

    @GetMapping("/recruiter")
    public List<Job> getRecruiterJobs(Authentication authentication){
        return jobService.getRecruiterJobs(authentication.getName());
    }

}
