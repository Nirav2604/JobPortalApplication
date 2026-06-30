package com.Portal.JobPortalApplication.repository;

import com.Portal.JobPortalApplication.entity.Company;
import com.Portal.JobPortalApplication.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job,Long> {

    List<Job> findByCompany(Company company);
    List<Job> findByTitleContainingIgnoreCase(String keyword);
    List<Job> findTop6ByOrderByPostedDateDesc();
}
