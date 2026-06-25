package com.Portal.JobPortalApplication.dto;

import lombok.Data;

@Data
public class CandidateProfileRequest {
    private String phone;
    private String skills;
    private String experience;
    private String education;
}
