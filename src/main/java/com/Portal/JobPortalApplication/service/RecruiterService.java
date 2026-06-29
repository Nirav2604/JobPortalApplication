package com.Portal.JobPortalApplication.service;

import com.Portal.JobPortalApplication.dto.CompanyRequest;
import com.Portal.JobPortalApplication.entity.Company;

public interface RecruiterService {

    Company createCompany(String email, CompanyRequest companyRequest);
    Company getCompany(String email);
    Company updateCompany(String email, CompanyRequest companyRequest);

}
