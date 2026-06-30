package com.Portal.JobPortalApplication.controller;

import com.Portal.JobPortalApplication.dto.DashboardResponse;
import com.Portal.JobPortalApplication.entity.Job;
import com.Portal.JobPortalApplication.entity.User;
import com.Portal.JobPortalApplication.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;


    @GetMapping("/dashboard")
    public DashboardResponse dashboard(){
        return adminService.getDashboard();
    }

    @GetMapping("/users")
    public List<User> users(){
        return adminService.getAllUsers();
    }

    @PutMapping("/users/{id}")
    public User updateStatus(@PathVariable Long id, @RequestParam boolean active){
        return adminService.updateUserStatus(id,active);
    }

    @GetMapping("/alljobs")
    public List<Job> jobs(){
        return adminService.getAllJobs();
    }

    @DeleteMapping("/users/{id}")
    public String deleteJob(@PathVariable Long id){
        adminService.deleteJob(id);
        return "Job Deleted Successfully!!!";
    }
}
