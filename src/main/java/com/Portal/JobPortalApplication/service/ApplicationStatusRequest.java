package com.Portal.JobPortalApplication.service;

import com.Portal.JobPortalApplication.entity.Application;

import java.util.List;

public interface ApplicationStatusRequest {
    Application applyJobs(Long jobId,String email);
    List<Application> getMyApplications(String email);
    List<Application> getApplicants(Long jobId, String recruiterEmail);
    Application updateStatus(Long applicationId, String recruiterEmail, String status);
}
