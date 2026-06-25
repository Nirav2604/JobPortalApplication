package com.Portal.JobPortalApplication.controller;

import com.Portal.JobPortalApplication.dto.CandidateProfileRequest;
import com.Portal.JobPortalApplication.entity.CandidateProfile;
import com.Portal.JobPortalApplication.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/candidate")
public class CandidateController {

    private final CandidateService candidateService;

    @PostMapping("/profile")
    public CandidateProfile createProfile(Authentication authentication, @RequestBody CandidateProfileRequest request){
        return candidateService.createProfile(authentication.getName(), request);
    }

    @GetMapping("/profile")
    public CandidateProfile getProfile(Authentication authentication) {
        return candidateService.getProfile(authentication.getName());
    }

    @PutMapping("/profile")
    public CandidateProfile updateProfile(Authentication authentication, @RequestBody CandidateProfileRequest request){
        return candidateService.UpdateProfile(authentication.getName(), request);
    }


}
