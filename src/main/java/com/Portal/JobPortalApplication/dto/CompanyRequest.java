package com.Portal.JobPortalApplication.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CompanyRequest {
    private String companyName;
    private String website;
    private String description;
    private String location;
}
