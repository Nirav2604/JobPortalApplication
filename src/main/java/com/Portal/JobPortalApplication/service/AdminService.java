package com.Portal.JobPortalApplication.service;

import com.Portal.JobPortalApplication.dto.DashboardResponse;
import com.Portal.JobPortalApplication.entity.Job;
import com.Portal.JobPortalApplication.entity.User;

import java.util.List;

public interface AdminService {

    DashboardResponse getDashboard();

    List<User> getAllUsers();

    User updateUserStatus(Long userId,Boolean active);

    List<Job> getAllJobs();

    void deleteJob(Long jobId);

}
