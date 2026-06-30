package com.Portal.JobPortalApplication.service.Implementation;

import com.Portal.JobPortalApplication.dto.JobRequest;
import com.Portal.JobPortalApplication.entity.Company;
import com.Portal.JobPortalApplication.entity.Job;
import com.Portal.JobPortalApplication.entity.User;
import com.Portal.JobPortalApplication.repository.CompanyRepository;
import com.Portal.JobPortalApplication.repository.JobRepository;
import com.Portal.JobPortalApplication.repository.UserRepository;
import com.Portal.JobPortalApplication.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;

    @Override
    public Job createJob(String email, JobRequest jobRequest) {
        User recruiter=userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("Email Not Found!!!"));
        Company company=companyRepository.findByRecruiter(recruiter).orElseThrow(()->new RuntimeException("Company Not Found!!!"));

        Job job=Job.builder()
                .title(jobRequest.getTitle())
                .description(jobRequest.getJobType())
                .location(jobRequest.getLocation())
                .salary(jobRequest.getSalary())
                .experienceRequired(jobRequest.getExperienceRequired())
                .skills(jobRequest.getSkills())
                .jobType(jobRequest.getJobType())
                .postedDate(LocalDateTime.now())
                .company(company)
                .build();
        return jobRepository.save(job);
    }

    @Override
    public Job updateJob(Long jobId, String email, JobRequest jobRequest) {
        Job job=jobRepository.findById(jobId).orElseThrow(()->new RuntimeException("Job Not Found"));
        job.setTitle(jobRequest.getTitle());
        job.setDescription(jobRequest.getDescription());
        job.setLocation(jobRequest.getLocation());
        job.setSalary(jobRequest.getSalary());
        job.setExperienceRequired(jobRequest.getExperienceRequired());
        job.setSkills(jobRequest.getSkills());
        job.setJobType(jobRequest.getJobType());

        return jobRepository.save(job);
    }

    @Override
    public Job deleteJob(Long jobId, String email) {
        jobRepository.deleteById(jobId);
        return null;
    }

    @Override
    public List<Job> getRecruiterJobs(String email) {
        User recruiter=userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("Email Not Found Of Recruiter!!"));
        Company company=companyRepository.findByRecruiter(recruiter).orElseThrow(()->new RuntimeException("Company not found!!"));

        return jobRepository.findByCompany(company);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(Long jobId) {
        return jobRepository.findById(jobId).orElseThrow();
    }

    @Override
    public List<Job> findByTitleContainingIgnoreCase(String keyword) {
        return jobRepository.findByTitleContainingIgnoreCase(keyword);
    }

    @Override
    public List<Job> getLatestJobs() {

        return jobRepository.findTop6ByOrderByPostedDateDesc();

    }
}
