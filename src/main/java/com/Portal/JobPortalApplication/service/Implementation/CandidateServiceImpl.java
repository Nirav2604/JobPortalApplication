package com.Portal.JobPortalApplication.service.Implementation;

import com.Portal.JobPortalApplication.dto.CandidateProfileRequest;
import com.Portal.JobPortalApplication.entity.CandidateProfile;
import com.Portal.JobPortalApplication.entity.User;
import com.Portal.JobPortalApplication.repository.CandidateProfileRepository;
import com.Portal.JobPortalApplication.repository.UserRepository;
import com.Portal.JobPortalApplication.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final UserRepository userRepository;
    private final CandidateProfileRepository candidateProfileRepository;

    @Override
    public CandidateProfile createProfile(String email, CandidateProfileRequest candidateProfileRequest) {
        User user = userRepository.findByEmail(email).orElseThrow();

        CandidateProfile candidateProfile = CandidateProfile.builder()
                .phone(candidateProfileRequest.getPhone())
                .skills(candidateProfileRequest.getSkills())
                .experience(candidateProfileRequest.getExperience())
                .education(candidateProfileRequest.getEducation())
                .active(candidateProfileRequest.getActive())
                .user(user)
                .build();

        return candidateProfileRepository.save(candidateProfile);
    }

    @Override
    public CandidateProfile getProfile(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        return candidateProfileRepository.findByUser(user).orElseThrow();
    }

    @Override
    public CandidateProfile UpdateProfile(String email, CandidateProfileRequest candidateProfileRequest) {
        User user = userRepository.findByEmail(email).orElseThrow();
        CandidateProfile candidateProfile= candidateProfileRepository.findByUser(user).orElseThrow();

        candidateProfile.setPhone(candidateProfileRequest.getPhone());
        candidateProfile.setSkills(candidateProfileRequest.getSkills());
        candidateProfile.setExperience(candidateProfileRequest.getExperience());
        candidateProfile.setEducation(candidateProfileRequest.getEducation());
        candidateProfile.setActive(candidateProfileRequest.getActive());
        return candidateProfileRepository.save(candidateProfile);
    }
}
