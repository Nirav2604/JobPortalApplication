package com.Portal.JobPortalApplication.service.Implementation;

import com.Portal.JobPortalApplication.dto.DashboardResponse;
import com.Portal.JobPortalApplication.entity.Job;
import com.Portal.JobPortalApplication.entity.Role;
import com.Portal.JobPortalApplication.entity.User;
import com.Portal.JobPortalApplication.exception.ResourceNotFoundException;
import com.Portal.JobPortalApplication.repository.ApplicationRepository;
import com.Portal.JobPortalApplication.repository.JobRepository;
import com.Portal.JobPortalApplication.repository.UserRepository;
import com.Portal.JobPortalApplication.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final JobRepository jobRepository;
    private final ApplicationRepository applicationRepository;

    @Override
    public DashboardResponse getDashboard() {
        return DashboardResponse.builder()
                .totalUsers(userRepository.count())
                .totalRecruiters(userRepository.findAll().stream().filter(user -> user.getRole()== Role.RECRUITER).count())
                .totalCandidates(userRepository.findAll().stream().filter(user -> user.getRole()== Role.CANDIDATE).count())
                .totalJobs(jobRepository.count())
                .totalApplications(applicationRepository.count())
                .build();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUserStatus(Long userId, boolean active) {
        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Not Found!!!!"));
        user.set_active(active);
        return userRepository.save(user);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public void deleteJobs(Long jobId) {
        if(!jobRepository.existsById(jobId)){
            throw new ResourceNotFoundException("Job Not Found");
        }
        jobRepository.deleteById(jobId);
    }
}
