package com.Portal.JobPortalApplication.service;

import com.Portal.JobPortalApplication.dto.JobRequest;
import com.Portal.JobPortalApplication.entity.Job;

import java.util.List;

public interface JobService {

    Job createJob(String email, JobRequest jobRequest);
    Job updateJob(Long jobId,String email,JobRequest jobRequest);
    Job deleteJob(Long jobId,String email);

    List<Job> getRecruiterJobs(String email);
    List<Job> getAllJobs();
    Job getJobById(Long jobId);
    List<Job> searchJobs(String keyword);
}
