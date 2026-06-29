package com.Portal.JobPortalApplication.controller;

import com.Portal.JobPortalApplication.dto.CandidateProfileRequest;
import com.Portal.JobPortalApplication.dto.CompanyRequest;
import com.Portal.JobPortalApplication.entity.CandidateProfile;
import com.Portal.JobPortalApplication.entity.Company;
import com.Portal.JobPortalApplication.service.RecruiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/recruiter")
public class RecruiterController {
    private final RecruiterService recruiterService;

    @PostMapping("/company")
    public Company createCompany(String email, @RequestBody CompanyRequest companyRequest){
       return recruiterService.createCompany(email,companyRequest);
    }

    @GetMapping("/company")
    public Company getCompany(String email){
        return recruiterService.getCompany(email);
    }

    @PutMapping("/company")
    public Company updateCompany(String email, @RequestBody CompanyRequest companyRequest){
        return recruiterService.updateCompany(email,companyRequest);
    }
}
