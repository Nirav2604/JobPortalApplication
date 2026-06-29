package com.Portal.JobPortalApplication.repository;

import com.Portal.JobPortalApplication.entity.Application;
import com.Portal.JobPortalApplication.entity.Job;
import com.Portal.JobPortalApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application,Long> {

    List<Application> findByCandidate(User Candidate);
    List<Application> findByJob(Job job);
    Optional<Application> findByCandidateAndJob(User candidate, Job job);
}
