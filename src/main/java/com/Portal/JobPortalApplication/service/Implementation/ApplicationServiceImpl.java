package com.Portal.JobPortalApplication.service.Implementation;

import com.Portal.JobPortalApplication.entity.*;
import com.Portal.JobPortalApplication.repository.ApplicationRepository;
import com.Portal.JobPortalApplication.repository.CompanyRepository;
import com.Portal.JobPortalApplication.repository.JobRepository;
import com.Portal.JobPortalApplication.repository.UserRepository;
import com.Portal.JobPortalApplication.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;

    @Override
    public Application applyJobs(Long jobId, String email) {
        User candidate=userRepository.findByEmail(email).orElseThrow();
        Job job=jobRepository.findById(jobId).orElseThrow();

        if(applicationRepository.findByCandidateAndJob(candidate,job).isPresent()){
            throw new RuntimeException("Already Applied");
        }

        Application application=Application.builder()
                .candidate(candidate)
                .job(job)
                .appliedDate(LocalDate.now())
                .status(ApplicationStatus.APPLIED)
                .build();

        return applicationRepository.save(application);
    }

    @Override
    public List<Application> getMyApplications(String email) {
        User candidate=userRepository.findByEmail(email).orElseThrow();
        return applicationRepository.findByCandidate(candidate);
    }

    @Override
    public List<Application> getApplicants(Long jobId, String recruiterEmail) {

        User recruiter = userRepository.findByEmail(recruiterEmail).orElseThrow();

        Company company=companyRepository.findByRecruiter(recruiter).orElseThrow();

        Job job=jobRepository.findById(jobId).orElseThrow();

        if(!job.getCompany().getId().equals(company.getId())){
            throw new RuntimeException("Unauthorized!!!");
        }

        return applicationRepository.findByJob(job);
    }
    @Override
    public Application updateStatus(Long applicationId, String recruiterEmail, String status) {

        Application application=applicationRepository.findById(applicationId).orElseThrow();

        User recruiter = userRepository.findByEmail(recruiterEmail).orElseThrow();

        Company company=companyRepository.findByRecruiter(recruiter).orElseThrow();

        if(!application.getJob().getCompany().getId().equals(company.getId())){
            throw new RuntimeException("Unauthorized!!!!");
        }
        application.setStatus(ApplicationStatus.valueOf(status));
        return applicationRepository.save(application);
    }
}
