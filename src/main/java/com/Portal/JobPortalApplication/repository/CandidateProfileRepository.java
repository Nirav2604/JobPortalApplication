package com.Portal.JobPortalApplication.repository;

import com.Portal.JobPortalApplication.entity.CandidateProfile;
import com.Portal.JobPortalApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateProfileRepository extends JpaRepository<CandidateProfile,Long> {
    Optional<CandidateProfile> findByUser(User user);
}
