package com.Portal.JobPortalApplication.repository;

import com.Portal.JobPortalApplication.entity.Company;
import com.Portal.JobPortalApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Long> {
    Optional<Company> findByRecruiter(User recruiter);

}
