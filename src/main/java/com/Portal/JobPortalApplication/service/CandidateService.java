package com.Portal.JobPortalApplication.service;

import com.Portal.JobPortalApplication.dto.CandidateProfileRequest;
import com.Portal.JobPortalApplication.entity.CandidateProfile;

public interface CandidateService {

    CandidateProfile createProfile(String email, CandidateProfileRequest candidateProfileRequest);
    CandidateProfile getProfile(String email);
    CandidateProfile UpdateProfile(String email, CandidateProfileRequest candidateProfileRequest);
}
